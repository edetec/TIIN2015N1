package sc.senai.br.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private EntityManagerFactory entityManagerFactory;
	private static JpaUtils instance;
	
	private JpaUtils(){
		
	}

	public static JpaUtils getInstance() {
		if (instance == null) {
			instance = new JpaUtils();
		}
		return instance;
	}

	public void createEntityManagerFactory() {
		if (this.entityManagerFactory == null)
			this.entityManagerFactory = Persistence.createEntityManagerFactory("ProjetoExemploSA_2016-1");
	}

	public void closeFactory() {
		this.entityManagerFactory.close();
	}

	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

}
