package br.senai.sc.tiin20151n1.pwa.introjpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("intro_jpa_pu");

	}

}
