package br.senai.sc.ctai.ti20151n1.pwa.agtur.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Perfil;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Usuario;

public class UsuarioDAO extends DAO {

	public void salvar(Usuario usuario) {
		getEM().merge(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return getEM().find(Usuario.class, id);
	}

	public List<Usuario> listarUsuarios() {
		Query query = getEM().createQuery("From Usuario", Usuario.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Usuario usuario = getEM().getReference(Usuario.class, id);
		getEM().remove(usuario);
	}

	public List<Usuario> listarAgentes() {
		Query query = getEM().createQuery("From Usuario u Where u.perfil = :perfil", Usuario.class);
		query.setParameter("perfil", Perfil.AGENTE);
		
		return query.getResultList();
	}

}
