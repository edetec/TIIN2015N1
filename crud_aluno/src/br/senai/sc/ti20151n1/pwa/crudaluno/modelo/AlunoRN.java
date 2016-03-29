package br.senai.sc.ti20151n1.pwa.crudaluno.modelo;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.ti20151n1.pwa.crudaluno.dao.AlunoDAO;

public class AlunoRN {
	private AlunoDAO dao;

	public AlunoRN() {
		dao = new AlunoDAO();
	}

	public void salvar(Aluno aluno) throws Exception {
		if (aluno.getNome().isEmpty()) {
			throw new Exception("O nome é obrigatorio.");
		}
		if (aluno.getNome().length() < 8 || !aluno.getNome().contains(" ")) {
			throw new Exception("Preencha o nome completo.");
		}

		dao.salvar(aluno);
	}

	public List<Aluno> listar() throws Exception {
		return dao.listar();
	}

	public void deletar(Long id) throws Exception {
		dao.deletar(id);
	}

	public Aluno buscarPorId(Long id) throws Exception {
		return dao.buscarProId(id);
	}
}
