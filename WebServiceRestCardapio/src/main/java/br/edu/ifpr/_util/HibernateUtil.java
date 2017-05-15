package br.edu.ifpr._util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	private static EntityManagerFactory entityManagerFactory;
	
	private static EntityManager entityManager = buildEntity();
	
	private static EntityManager buildEntity(){
		try{
			
			entityManagerFactory = Persistence.createEntityManagerFactory("persistence_cardapio");
			
			entityManager = entityManagerFactory.createEntityManager();
			
			return entityManager;
			
		}catch (Exception e) {
			System.out.println("Problema com o Banco!\n" + e);
			throw new ExceptionInInitializerError();
		}

		
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
}

