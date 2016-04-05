package sc.senai.br.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="autor",schema="bolinhajpa_db")
public class Autor implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private List<Livro> livros;
	
	public Autor() {
		this.livros = new ArrayList<Livro>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "autor_livro",
			joinColumns=@JoinColumn(name="idAutor",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="idLivro",referencedColumnName="id"))
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}













