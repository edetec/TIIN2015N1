package br.senai.sc.tiin20151n1.pwa.introjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.senai.sc.tiin20151n1.pwa.introjpa.model.entity.Aluno;

public class Main {

	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("intro_jpa_pu");

//		adicionarAluno();
//		alterarAluno();
//		listarAlunos();
//		buscarAlunoPorId();
		removerAlunoPorId();
		
		emf.close();
	}

	private static void removerAlunoPorId() {
		Long id = 1L;
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Aluno aluno = em.getReference(Aluno.class, id);
		em.remove(aluno);
		
		em.getTransaction().commit();
		em.close();
	}

	private static void buscarAlunoPorId() {
		Long id = 2L;
		
		EntityManager em = emf.createEntityManager();
		
		Aluno aluno = em.find(Aluno.class, id);
		
		em.close();
		
		System.out.println("Nome: " + aluno.getNome());
		System.out.println("Email: " + aluno.getEmail());
		System.out.println("------------------------------------------");
	}

	private static void listarAlunos() {
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("From Aluno", Aluno.class);
		List<Aluno> alunos = query.getResultList();
		
		em.close();
		
		for (Aluno aluno : alunos) {
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("------------------------------------------");
		}
	}

	private static void alterarAluno() {
		Aluno aluno = new Aluno();
		aluno.setId(1L);
		aluno.setEmail("ana@ana.net");
		aluno.setNome("Ana");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(aluno);
		
		em.getTransaction().commit();
		em.close();
	}

	private static void adicionarAluno() {
		Aluno aluno = new Aluno();
		aluno.setEmail("ana@mail.com");
		aluno.setNome("Ana Maria");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(aluno);
		
		em.getTransaction().commit();
		em.close();
	}

}
