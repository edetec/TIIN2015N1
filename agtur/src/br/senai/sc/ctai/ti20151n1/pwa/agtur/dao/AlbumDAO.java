package br.senai.sc.ctai.ti20151n1.pwa.agtur.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Imagem;

public class AlbumDAO extends DAO {

	public void salvar(Imagem foto) {
		getEM().merge(foto);
	}

	public List<Imagem> listarImagensPorEscursao(Long idEscursao) {
		Query query = getEM().createQuery(
				"From Imagem i Where i.escursao.id = :idEscursao "
				, Imagem.class);
		query.setParameter("idEscursao", idEscursao);
		return query.getResultList();
	}

	public Imagem buscarImagemPorId(Long idImagem) {
		return getEM().find(Imagem.class, idImagem);
	}

	public void excluir(Imagem imagem) {
		getEM().remove(imagem);
	}

}
