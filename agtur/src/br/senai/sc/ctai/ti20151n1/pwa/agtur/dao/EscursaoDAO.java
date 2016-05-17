package br.senai.sc.ctai.ti20151n1.pwa.agtur.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;

public class EscursaoDAO extends DAO {

	public List<Escursao> listar() {
		Query query = getEM().createQuery("From Escursao", Escursao.class);
		return query.getResultList();
	}

	public void salvar(Escursao escursao) throws SQLException {
		getEM().merge(escursao);
	}

	public Escursao buscarPorId(Long id) {
		return getEM().find(Escursao.class, id);
	}

}
