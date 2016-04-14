package br.senai.sc.tiin20151n1.pwa.introjpa.model;

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

}
