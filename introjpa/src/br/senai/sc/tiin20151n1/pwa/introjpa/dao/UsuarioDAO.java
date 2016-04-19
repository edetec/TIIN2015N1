package br.senai.sc.tiin20151n1.pwa.introjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.tiin20151n1.pwa.introjpa.commons.JpaUtil;
import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Usuario;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		em.merge(usuario);
	}

	public Usuario buscarPorId(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		return em.find(Usuario.class, id);
	}

	public List<Usuario> listarUsuarios() {
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createQuery("From Usuario", Usuario.class);
		return query.getResultList();
	}

}
