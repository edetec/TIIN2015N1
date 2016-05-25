package br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Imagem {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Date data;
	@ManyToOne
	private Escursao escursao;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Escursao getEscursao() {
		return escursao;
	}

	public void setEscursao(Escursao escursao) {
		this.escursao = escursao;
	}
}
