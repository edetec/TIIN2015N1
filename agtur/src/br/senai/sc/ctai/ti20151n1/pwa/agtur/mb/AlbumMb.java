package br.senai.sc.ctai.ti20151n1.pwa.agtur.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import br.senai.sc.ctai.ti20151n1.pwa.agtur.commons.UploadUtil;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Escursao;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity.Imagem;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.AlbumRN;
import br.senai.sc.ctai.ti20151n1.pwa.agtur.model.rn.EscursaoRN;

@ViewScoped
@ManagedBean(name = "albumMb")
public class AlbumMb {

	private String escursaoId;
	private Escursao escursao;
	private Imagem foto;
	
	private Part fotoUploaded;
	private List<Imagem> imagens;
	private AlbumRN albumRN;
	private EscursaoRN escursaoRN;

	@PostConstruct
	public void init() {
		escursaoRN = new EscursaoRN();
		albumRN = new AlbumRN();
		foto = new Imagem();
		escursao = new Escursao();
	}

	public Escursao getEscursao() {
		return escursao;
	}

	public void setEscursao(Escursao escursao) {
		this.escursao = escursao;
	}

	public List<Imagem> getImagens() {
		if (imagens == null && escursao != null && escursao.getId() != null) {
			imagens = albumRN.listarImagensPorEscursao(escursao.getId());
		}
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Imagem getFoto() {
		return foto;
	}

	public void setFoto(Imagem foto) {
		this.foto = foto;
	}

	public Part getFotoUploaded() {
		return fotoUploaded;
	}

	public void setFotoUploaded(Part fotoUploaded) {
		this.fotoUploaded = fotoUploaded;
	}

	public String getEscursaoId() {
		return escursaoId;
	}

	public void setEscursaoId(String escursaoId) {
		this.escursaoId = escursaoId;
	}

	public void load(){
		if(escursaoId != null){
			Long id = Long.parseLong(escursaoId);
			escursao = escursaoRN.buscarPorId(id );
		}
	}
	
	public void excluir(String idImg){
		Long id = Long.parseLong(idImg);
		Imagem img = albumRN.buscarImagemPorId(id);
		
		UploadUtil.removerArquivo(img.getNome());
		albumRN.excluir(img);
		
		imagens = null;
	}

	public String salvar() {
		try {
			String nome = UploadUtil.moverArquivo(fotoUploaded, foto.getNome());

			foto.setNome(nome);
			foto.setEscursao(escursao);

			albumRN.adicionar(foto);

			return "/album?idescursao=" + escursao.getId().toString()
					+ "&faces-redirect=true";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
