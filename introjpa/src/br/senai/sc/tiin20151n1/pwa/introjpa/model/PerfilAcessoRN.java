package br.senai.sc.tiin20151n1.pwa.introjpa.model;

import java.util.List;

import br.senai.sc.tiin20151n1.pwa.introjpa.dao.PerfilAcessoDAO;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.PerfilAcesso;

public class PerfilAcessoRN {

	private PerfilAcessoDAO dao;

	public PerfilAcessoRN() {
		dao = new PerfilAcessoDAO();
	}
	
	public List<PerfilAcesso> listar() {
		return dao.listar();
	}

	public PerfilAcesso buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

}
