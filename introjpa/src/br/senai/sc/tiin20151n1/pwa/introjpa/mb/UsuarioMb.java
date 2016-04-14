package br.senai.sc.tiin20151n1.pwa.introjpa.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.tiin20151n1.pwa.introjpa.model.UsuarioRN;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Usuario;

@ManagedBean
public class UsuarioMb {
	private Usuario usuario;
	private UsuarioRN usuarioRN;
	
	@PostConstruct
	public void depoisDeConstruir(){
		usuario = new Usuario();
		usuarioRN = new UsuarioRN();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public String salvar(){
		usuarioRN.salvar(usuario);
		return "";
	}
	
}
