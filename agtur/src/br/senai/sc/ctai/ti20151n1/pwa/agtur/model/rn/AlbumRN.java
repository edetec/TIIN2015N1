package br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn;

import java.util.List;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.dao.AlbumDAO;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Imagem;

public class AlbumRN {

	private AlbumDAO dao;

	public AlbumRN() {
		dao = new AlbumDAO();
	}

	public void adicionar(Imagem foto) {
		dao.salvar(foto);
	}

	public List<Imagem> listarImagensPorEscursao(Long idEscursao) {
		return dao.listarImagensPorEscursao(idEscursao);
	}

	public Imagem buscarImagemPorId(Long idImagem) {
		return dao.buscarImagemPorId(idImagem);
	}

	public void excluir(Imagem imagem) {
		dao.excluir(imagem);
	}

}
