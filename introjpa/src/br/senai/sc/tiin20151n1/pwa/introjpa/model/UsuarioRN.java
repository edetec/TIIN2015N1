package br.senai.sc.tiin20151n1.pwa.introjpa.model;

import java.util.List;

import br.senai.sc.tiin20151n1.pwa.introjpa.dao.UsuarioDAO;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Usuario;

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

}
