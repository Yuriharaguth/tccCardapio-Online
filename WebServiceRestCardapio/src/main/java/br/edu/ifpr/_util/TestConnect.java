package br.edu.ifpr._util;

import javax.persistence.EntityManager;

public class TestConnect {

	public static void main(String[] args) {
		try{
			EntityManager entityManager = HibernateUtil.getEntityManager();
			if(entityManager.isOpen()){
				System.out.println("Aberta!");
			}else{
				System.out.println("Fechada!!");
			}
				
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
		
		}
	}
	

}
