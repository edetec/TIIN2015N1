package br.senai.sc.ctai.ti20151n1.pwa.agtur.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Usuario;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.EscursaoRN;

@ViewScoped
@ManagedBean(name="escursaoMb")
public class EscursaoMb {

	private List<Escursao> listaEscursao;
	private EscursaoRN escursaoRN;
	private Escursao escursao;

	private Long editarId;

	private Usuario clienteSelecionado;

	@PostConstruct
	public void init() {
		escursaoRN = new EscursaoRN();
		escursao = new Escursao();
		escursao.setClientesEscursao(new ArrayList<Usuario>());
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

	public Usuario getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Usuario clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public void carregarEdicao() {
		if (editarId != null &&  
				!FacesContext.getCurrentInstance()
				.getPartialViewContext().isAjaxRequest()) {
			escursao = escursaoRN.buscarPorId(editarId);
		}
	}

	public void adicionarCliente(AjaxBehaviorEvent event) {
		if(escursao.getClientesEscursao().contains(clienteSelecionado)){
			return;
		}
		escursao.getClientesEscursao().add(clienteSelecionado);
		clienteSelecionado = null;
	}

	public void excluirCliente(AjaxBehaviorEvent event) {
		Usuario cliente = (Usuario) event.getComponent().getAttributes()
				.get("idCliente");
		escursao.getClientesEscursao().remove(cliente);
	}
	
	public String excluir(String idParam){
		Long id = Long.parseLong(idParam);
		escursaoRN.excluir(id);
		listaEscursao = null;
		
		return "";
	}

	public String salvar() throws Throwable {
		try {
			escursaoRN.salvar(escursao);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/admin/escursoes";
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
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e
							.getMessage()));
		}
		return "";
	}

}
