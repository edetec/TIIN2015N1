package br.senai.sc.ctai.ti20151n1.pwa.agtur.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Usuario;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.UsuarioRN;

@ManagedBean
public class UsuarioMb {
	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private Long editarId;
	private List<Usuario> listaUsuarios;
	private List<Usuario> listaAgentes;
	
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

	public List<Usuario> getListaUsuarios() {
		if(listaUsuarios == null){
			listaUsuarios = usuarioRN.listarUsuarios();
		}
		return listaUsuarios;
	}
	
	public List<Usuario> getListaAgentes(){
		if(listaAgentes == null){
			listaAgentes = usuarioRN.listarAgentes();
		}
		return listaAgentes;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void carregarUsuario(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		usuario = usuarioRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		usuarioRN.excluir(idExcluir);
		listaUsuarios = null;
		return "";
	}
	
	public String salvar(){
		usuarioRN.salvar(usuario);
		listaUsuarios = null;
		return "";
	}
	
}
