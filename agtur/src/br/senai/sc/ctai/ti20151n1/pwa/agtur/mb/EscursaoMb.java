package br.senai.sc.ctai.ti20151n1.pwa.agtur.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.EscursaoRN;

@ManagedBean
public class EscursaoMb {
	
	private List<Escursao> listaEscursao;
	private EscursaoRN escursaoRN;
	private Escursao escursao;
	
	@PostConstruct
	public void init(){
		escursaoRN = new EscursaoRN();
		escursao = new Escursao();
	}

	public List<Escursao> getListaEscursao() {
		if(listaEscursao == null){
			listaEscursao = escursaoRN.listar();
		}
		return listaEscursao;
	}

	public void setListaEscursao(List<Escursao> listaEscursao) {
		this.listaEscursao = listaEscursao;
	}

	public Escursao getEscursao() {
		return escursao;
	}

	public void setEscursao(Escursao escursao) {
		this.escursao = escursao;
	}
	
}
