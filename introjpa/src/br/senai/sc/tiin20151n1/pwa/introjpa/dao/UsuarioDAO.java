package br.senai.sc.tiin20151n1.pwa.introjpa.dao;

import javax.persistence.EntityManager;

import br.senai.sc.tiin20151n1.pwa.introjpa.commons.JpaUtil;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Usuario;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		em.merge(usuario);
	}

}
