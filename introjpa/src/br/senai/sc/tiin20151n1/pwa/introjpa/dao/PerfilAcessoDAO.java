package br.senai.sc.tiin20151n1.pwa.introjpa.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.PerfilAcesso;

public class PerfilAcessoDAO extends DAO {
	public PerfilAcesso buscarPorId(Long id) {
		return getEM().find(PerfilAcesso.class, id);
	}

	public List<PerfilAcesso> listar() {
		Query query = getEM().createQuery("From PerfilAcesso",
				PerfilAcesso.class);
		return query.getResultList();
	}
}
