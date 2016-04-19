package br.senai.sc.tiin20151n1.pwa.introjpa.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

import br.senai.sc.tiin20151n1.pwa.introjpa.model.UsuarioRN;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Usuario;

@ManagedBean
public class UsuarioMb {
	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private Long editarId;
	
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
	
	
	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public void carregarUsuario(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		usuario = usuarioRN.buscarPorId(editarId);
	}
	
	public String salvar(){
		usuarioRN.salvar(usuario);
		return "";
	}
	
}
