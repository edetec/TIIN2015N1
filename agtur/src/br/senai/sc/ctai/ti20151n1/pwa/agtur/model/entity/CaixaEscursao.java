package br.senai.sc.ctai.ti20151n1.pwa.agtur.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name="caixa_escursoes")
@Immutable
public class CaixaEscursao {

	@Id
	@Column(name = "escursao_id")
	private Long idEscursao;
	private String destino;
	@Column(name = "clientes")
	private Integer qtdClientes;
	private Float total;
	private Date data;

	public Long getIdEscursao() {
		return idEscursao;
	}

	public void setIdEscursao(Long idEscursao) {
		this.idEscursao = idEscursao;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getQtdClientes() {
		return qtdClientes;
	}

	public void setQtdClientes(Integer qtdClientes) {
		this.qtdClientes = qtdClientes;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
