package br.edu.ifpr.repository.dao;

import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr.repository.entity.Comentario;

import java.util.List;

import javax.persistence.EntityManager;

public class ComentarioDao {
	
	private EntityManager entityManager;
	
	public ComentarioDao(){
		entityManager = HibernateUtil.getEntityManager();
	}
	
	public boolean merge(Comentario com){
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(com);
			entityManager.getTransaction().commit();
			return true;
			
		}catch(Exception e) {
			System.out.println(e.getMessage() +  "Erro ao cadastrar um comentario");
			return false;
		}
		finally{
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Comentario> list(){
		try{
			entityManager.getTransaction().begin();
			List<Comentario> Comentarios = entityManager.createQuery("from Comentario").getResultList();
			entityManager.getTransaction().commit();
			return Comentarios;
		}finally{
		}
	}

}
