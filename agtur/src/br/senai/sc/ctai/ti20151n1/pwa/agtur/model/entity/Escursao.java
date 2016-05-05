package br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Escursao {

	@Id
	@GeneratedValue
	private Long id;
	private String destino;
	private Date partida;
	private Date retorno;
	private Float valor;
	@ManyToOne
	private Usuario agente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getPartida() {
		return partida;
	}

	public void setPartida(Date partida) {
		this.partida = partida;
	}

	public Date getRetorno() {
		return retorno;
	}

	public void setRetorno(Date retorno) {
		this.retorno = retorno;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Usuario getAgente() {
		return agente;
	}

	public void setAgente(Usuario agente) {
		this.agente = agente;
	}

}
