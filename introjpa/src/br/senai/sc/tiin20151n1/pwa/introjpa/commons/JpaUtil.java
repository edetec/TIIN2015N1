package br.senai.sc.tiin20151n1.pwa.introjpa.commons;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory EMF;

	public static void init() {
		if (EMF == null) {
			EMF = Persistence.createEntityManagerFactory("intro_jpa_pu");
		}
	}
		
	public static void destroy(){
		EMF.close();
	}
}
