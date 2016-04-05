package sc.senai.br;

import javax.persistence.EntityManager;

import sc.senai.br.common.JpaUtils;
import sc.senai.br.model.Autor;
import sc.senai.br.model.Departamento;
import sc.senai.br.model.Estado;
import sc.senai.br.model.Funcionario;
import sc.senai.br.model.Livro;
import sc.senai.br.model.Pedido;

public class Principal {
	
	public static void main(String[] args) {
		
		JpaUtils.getInstance().createEntityManagerFactory();
		EntityManager em = JpaUtils.getInstance().getEntityManager();

		//Adicionando Governador ao Estado
		Estado e = new Estado();
		e.setNome("Santa Catarina");
		e.getGovernador().setNome("Raimundo Colombo");

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		///////////////////////////////////////////////
		
		// Adicionando Pedido para um Cliente
		em.getTransaction().begin();
		Pedido p = new Pedido();
		p.getCliente().setNome("Bolinha da Silva");
		p.setNome("pedido 1 - " + p.getCliente().getNome());
		em.persist(p);
		em.getTransaction().commit();
		///////////////////////////////////////////////
		
		//Adicionando Funcionario ao Departamento
		em.getTransaction().begin();
		Departamento d = new Departamento();
		d.setNome("Departamento de funcionários bons");
		Funcionario f = new Funcionario();
		f.setNome("Funcionário padrão");
		d.getFuncionarios().add(f);
		em.persist(d);
		em.getTransaction().commit();
		///////////////////////////////////////////////

		//Adicionando Livro no autor
		em.getTransaction().begin();
		Autor a = new Autor();
		a.setNome("Autor da Bolinha");
		Livro l = new Livro();
		l.setNome("Bolinha encantada");
		a.getLivros().add(l);
		em.persist(a);
		em.getTransaction().commit();
		///////////////////////////////////////////////
		
		em.close();
		JpaUtils.getInstance().closeFactory();
		
	}

}
