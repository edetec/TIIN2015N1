package br.senai.sc.ctai.ti20151n1.pwa.agtur.dao;

import javax.persistence.EntityManager;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.commons.JpaUtil;

public abstract class DAO {

	public DAO() {
		super();
	}

	protected EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}