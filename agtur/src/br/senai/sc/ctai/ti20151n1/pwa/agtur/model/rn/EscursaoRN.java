package br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn;

import java.util.List;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.dao.EscursaoDAO;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;

public class EscursaoRN {

	private EscursaoDAO dao;

	public EscursaoRN() {
		dao = new EscursaoDAO();
	}

	public List<Escursao> listar() {
		return dao.listar();
	}

}
