package br.senai.sc.ctai.ti20151n1.pwa.agtur.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.EscursaoRN;

@ManagedBean
public class EscursaoMb {

	private List<Escursao> listaEscursao;
	private EscursaoRN escursaoRN;
	private Escursao escursao;

	@PostConstruct
	public void init() {
		escursaoRN = new EscursaoRN();
		escursao = new Escursao();
	}

	public List<Escursao> getListaEscursao() {
		if (listaEscursao == null) {
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

	public String salvar() throws Throwable {
		try {
			escursaoRN.salvar(escursao);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/escursoes";
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
							exception.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
							e.getMessage()));
		}
		return "";
	}

}
