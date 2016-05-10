package br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn;

import java.sql.SQLException;
import java.util.List;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.dao.EscursaoDAO;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Perfil;

public class EscursaoRN {

	private EscursaoDAO dao;

	public EscursaoRN() {
		dao = new EscursaoDAO();
	}

	public List<Escursao> listar() {
		return dao.listar();
	}

	public void salvar(Escursao escursao) throws IllegalArgumentException, Exception {
		if(escursao.getAgente() == null){
			throw new IllegalArgumentException("É preciso selecionar um Agente");
		}
		if(!escursao.getAgente().getPerfil().equals(Perfil.AGENTE)){
			throw new IllegalArgumentException("É preciso selecionar um Agente");
		}
		
		try{
			dao.salvar(escursao);
		}catch (SQLException e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}
}
