package br.senai.sc.ctai.ti20151n1.pwa.agtur.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.CaixaEscursao;

public class CaixaEscursaoDAO extends DAO {

	public List<CaixaEscursao> buscarPorPeriodo(Date inicio, Date fim) {
		Query query = getEM().createQuery(
				"From CaixaEscursao c"
				+ " Where c.data between :inicio and :fim",
				CaixaEscursao.class);
		
		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		
		return query.getResultList();
	}
}
