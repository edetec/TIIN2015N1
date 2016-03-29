package br.senai.sc.ti20151n1.pwa.crudaluno.modelo;

public class Aluno {
	private Long id;
	private String nome;
	private String email;
	private Boolean noticias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getNoticias() {
		return noticias;
	}

	public void setNoticias(Boolean noticias) {
		this.noticias = noticias;
	}
}
