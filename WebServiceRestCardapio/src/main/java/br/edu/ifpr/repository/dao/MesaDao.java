package br.edu.ifpr.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr.repository.entity.Mesa;

public class MesaDao {
	
	private EntityManager entityManager;
	
	public MesaDao(){
		entityManager = HibernateUtil.getEntityManager();
	}
	
	public boolean create(Mesa mesa){
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(mesa);
			entityManager.getTransaction().commit();
			return true;
			
		}finally{
			//entityManager.close();
		}
	}
	
	public Mesa find(long id){
		try{
			entityManager.getTransaction().begin();
			return entityManager.find(Mesa.class, id);
		}finally{
			entityManager.getTransaction().commit();
			//session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Mesa> list(){
		try{
			entityManager.getTransaction().begin();;
			List<Mesa> mesas = entityManager.createQuery("from Mesa").getResultList();
			entityManager.getTransaction().commit();
			return mesas;
		}finally{
			
			//entityManager.close();
		}
	}
	
	public boolean updateMesa( Mesa mesa ){
		try{
			entityManager.getTransaction().begin();;
			entityManager.createQuery("UPDATE Mesa m set m.ativo = ?1 where m.id = ?2")
				.setParameter(1, mesa.getAtivo())
				.setParameter(2, mesa.getId())
				.executeUpdate();
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.getMessage();
			return false;
		}
		finally{
			//entityManager.close();
		}	
	}
	
	public static void main(String[] args) {
		/*
		Mesa mesa = new Mesa();
		MesaDao mDao = new MesaDao();
		
		mesa = mDao.find(2);
		*/
	}
		
}