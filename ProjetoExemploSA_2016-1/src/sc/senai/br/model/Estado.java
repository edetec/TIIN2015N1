package sc.senai.br.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estado", schema = "bolinhajpa_db")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Governador governador;

	public Estado() {
		this.governador = new Governador();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idGovernador")
	public Governador getGovernador() {
		return this.governador;
	}

	public void setGovernador(Governador governador) {
		this.governador = governador;
	}

}