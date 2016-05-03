package br.senai.sc.tiin20151n1.pwa.introjpa.dao;

import javax.persistence.EntityManager;

import br.senai.sc.tiin20151n1.pwa.introjpa.commons.JpaUtil;

public abstract class DAO {
	
	EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}