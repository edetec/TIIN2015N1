package br.senai.sc.ctai.ti20151n1.pwa.agtur.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Perfil;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Usuario;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.UsuarioRN;

@SessionScoped
@ManagedBean
public class SessaoMb {

	private String emailForm;
	private String senhaForm;
	private Usuario usuarioLogado;

	public String getSenhaForm() {
		return senhaForm;
	}

	public void setSenhaForm(String senhaForm) {
		this.senhaForm = senhaForm;
	}

	public String getEmailForm() {
		return emailForm;
	}

	public void setEmailForm(String emailForm) {
		this.emailForm = emailForm;
	}

	public boolean estaLogado() {
		return usuarioLogado != null;
	}

	public boolean ehAdmin() {
		return usuarioLogado != null
				&& usuarioLogado.getPerfil().equals(Perfil.ADMIN);
	}

	public String getNomeUsuarioLogato() {
		return usuarioLogado == null ? "" : usuarioLogado.getNome();
	}

	public String sair() {
		usuarioLogado = null;
		return "/index?faces-redirect=true";
	}

	public String entrar() {
		UsuarioRN usuarioRN = new UsuarioRN();
		
		if (emailForm != null && !emailForm.isEmpty() 
				&& senhaForm != null && !senhaForm.isEmpty()) {
			
			Usuario usuario = usuarioRN.buscarPorEmail(emailForm);

			if (usuario != null
					&& usuario.getEmail().equalsIgnoreCase(emailForm)
					&& usuario.getSenha().equals(senhaForm)) {
				usuarioLogado = usuario;

				return "/admin/escursoes?faces-redirect=true";
			}
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("E-mail ou senha não confere."));
		return "";
	}
}
