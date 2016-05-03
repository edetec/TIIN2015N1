package br.senai.sc.tiin20151n1.pwa.introjpa.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

import br.senai.sc.tiin20151n1.pwa.introjpa.model.PerfilAcessoRN;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.UsuarioRN;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.PerfilAcesso;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Usuario;

@ManagedBean
public class UsuarioMb {
	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private Long editarId;
	private List<Usuario> listaUsuarios;
	private List<PerfilAcesso> listaPerfis;
	private PerfilAcessoRN perfilAcessoRN;
	
	@PostConstruct
	public void depoisDeConstruir(){
		usuario = new Usuario();
		usuarioRN = new UsuarioRN();
		perfilAcessoRN = new PerfilAcessoRN();
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

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<PerfilAcesso> getListaPerfis() {
		if(listaPerfis == null){
			listaPerfis = perfilAcessoRN.listar();
		}
		return listaPerfis;
	}

	public void setListaPerfis(List<PerfilAcesso> listaPerfis) {
		this.listaPerfis = listaPerfis;
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
	
//	public String salvar(){
//		usuarioRN.salvar(usuario);
//		usuario = new Usuario();
//		return "";
//	}
	
	public String salvar(){
		usuarioRN.salvar(usuario);
		listaUsuarios = null;
		return "/userList";
	}
}
