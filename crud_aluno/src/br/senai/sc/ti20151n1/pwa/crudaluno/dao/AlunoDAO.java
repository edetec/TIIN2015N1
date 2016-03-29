package br.senai.sc.ti20151n1.pwa.crudaluno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.senai.sc.ti20151n1.pwa.crudaluno.modelo.Aluno;

public class AlunoDAO {

	private static Connection conn;

	private Connection getConexao() throws SQLException {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/crudaluno";
			String user = "root";
			String password = "root";

			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;
	}

	public void salvar(Aluno aluno) throws SQLException {
		if (aluno.getId()!= null) {
			alterar(aluno);
		} else {
			inserir(aluno);
		}

	}

	private void alterar(Aluno aluno) throws SQLException {
		PreparedStatement statement = getConexao().prepareStatement(
				"UPDATE aluno SET email=?,nome=?,noticias=? WHERE idaluno = ?");

		statement.setString(1, aluno.getEmail());
		statement.setString(2, aluno.getNome());
		statement.setBoolean(3, aluno.getNoticias());
		statement.setLong(4, aluno.getId());

		statement.execute();
	}

	private void inserir(Aluno aluno) throws SQLException {
		PreparedStatement statement = getConexao().prepareStatement(
				"INSERT aluno(email,nome,noticias) values(?,?,?)");

		statement.setString(1, aluno.getEmail());
		statement.setString(2, aluno.getNome());
		statement.setBoolean(3, aluno.getNoticias());

		statement.execute();
	}

	public List<Aluno> listar() throws SQLException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		PreparedStatement statment = getConexao().prepareStatement(
				"SELECT * FROM aluno;");
		ResultSet rs = statment.executeQuery();
		while (rs.next()) {
			alunos.add(parseObject(rs));
		}
		return alunos;
	}

	private Aluno parseObject(ResultSet rs) throws SQLException {
		Aluno aluno = new Aluno();
		aluno.setId(rs.getLong("idaluno"));
		aluno.setEmail(rs.getString("email"));
		aluno.setNome(rs.getString("nome"));
		aluno.setNoticias(rs.getBoolean("noticias"));
		return aluno;
	}

	public void deletar(Long id) throws SQLException {
		PreparedStatement statement = getConexao().prepareStatement(
				"DELETE FROM aluno WHERE idaluno = ?");
		statement.setLong(1, id);
		statement.execute();
	}

	public Aluno buscarProId(Long id) throws SQLException {
		PreparedStatement statement = getConexao().prepareStatement(
				"SELECT * FROM aluno WHERE idaluno = ?");
		statement.setLong(1, id);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			return parseObject(rs);
		}

		return null;
	}

}
