package br.edu.ifpr.categoria.dao;

import java.util.List;

import org.hibernate.Session;

import br.edu.ifpr._config.HibernateUtil;
import br.edu.ifpr.categoria.pojo.Categoria;

public class CategoriaDao {
	
	private Session session;

	public CategoriaDao(){
		session = HibernateUtil.getSession().openSession();
	}
	
	public boolean merge(Categoria cat){
		try{
			session.beginTransaction();
			session.merge(cat);
			session.getTransaction().commit();
			return true;
			
		}finally{
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> list(){
		try{
			session.beginTransaction();
			List<Categoria> categorias = session.createQuery("from Categoria").getResultList();
			/*
			for(Categoria cat : categorias){
				System.out.println(cat);
			}
			*/
			session.getTransaction().commit();
			return categorias;
		}finally{
			//session.close();
		}
	}
	
	public Categoria find(long id){
		try{
			session.beginTransaction();
			return session.get(Categoria.class, id);
		}finally{
			session.getTransaction().commit();
			//session.close();
		}
	}
	
	public boolean updateCategoria(Categoria cat, long id){
		try{
			session.beginTransaction();
			//session.update(arg0, arg1);
			session.createQuery("UPDATE Categoria c set c.nome = ?1, c.descricao = ?2 where c.id = ?3")
				.setParameter(1, cat.getNome())
				.setParameter(2, cat.getDescricao())
				.setParameter(3, id)
				.executeUpdate();
			session.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}	
	}
	
	public boolean delete(Categoria cat){
		try{
			session.beginTransaction();
			session.delete(cat);
			session.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}
	}
	
	public static void main(String[] args) {
		

	}

}
