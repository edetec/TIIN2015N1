package br.senai.sc.ctai.ti20151n1.pwa.agtur.rn;

import java.util.Date;
import java.util.List;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.dao.CaixaEscursaoDAO;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.CaixaEscursao;

public class CaixaEscursaoRN {
	private CaixaEscursaoDAO dao;

	public CaixaEscursaoRN() {
		dao = new CaixaEscursaoDAO();
	}

	public List<CaixaEscursao> buscarPorPeriodo(Date inicio, Date fim) {
		return dao.buscarPorPeriodo(inicio, fim);
	}
}
