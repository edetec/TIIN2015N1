package br.senai.sc.tiin20151n1.pwa.introjpa.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Usuario;

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

}
