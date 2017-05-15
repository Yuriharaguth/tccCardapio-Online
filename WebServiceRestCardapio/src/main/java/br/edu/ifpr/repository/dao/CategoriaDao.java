package br.edu.ifpr.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr.repository.entity.Categoria;

public class CategoriaDao {
	
	private EntityManager entityManager;


	public CategoriaDao(){
		entityManager = HibernateUtil.getEntityManager();
	}
	
	public boolean merge(Categoria cat){
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(cat);
			entityManager.getTransaction().commit();
			return true;
			
		}finally{
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> list(){
		try{
			entityManager.getTransaction().begin();
			List<Categoria> categorias = entityManager.createQuery("from Categoria").getResultList();
			entityManager.getTransaction().commit();
			return categorias;
		}finally{
		}
	}
	
	public Categoria find(long id){
		try{
			entityManager.getTransaction().begin();
			return entityManager.find(Categoria.class, id);
		}finally{
			entityManager.getTransaction().commit();
		}
	}
	
	public boolean updateCategoria(Categoria cat, long id){
		try{
			entityManager.getTransaction().begin();
			entityManager.createQuery("UPDATE Categoria c set c.nome = ?1, c.descricao = ?2 where c.id = ?3")
				.setParameter(1, cat.getNome())
				.setParameter(2, cat.getDescricao())
				.setParameter(3, id)
				.executeUpdate();
			entityManager.getTransaction().commit();
			return true;
		}finally{
			
		}	
	}
	
	public boolean delete(Categoria cat){
		try{
			entityManager.getTransaction().begin();
			entityManager.remove(cat);
			entityManager.getTransaction().commit();
			return true;
		}finally{
		}
	}
	
	public static void main(String[] args) {
		

	}

}