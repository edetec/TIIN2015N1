package br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn;

import java.util.List;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.dao.UsuarioDAO;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Usuario;

public class UsuarioRN {

	private UsuarioDAO dao;

	public UsuarioRN() {
		dao = new UsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		dao.salvar(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Usuario> listarUsuarios() {
		return dao.listarUsuarios();
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}

	public List<Usuario> listarAgentes() {
		return dao.listarAgentes();
	}

	public Usuario buscarPorEmail(String email) {
		return dao.buscarPorEmail(email);
	}

}
