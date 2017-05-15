package br.edu.ifpr.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;


import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr.repository.entity.User;



public class UserDao {
	
	private EntityManager entityManager;

	public UserDao(){
		 entityManager = HibernateUtil.getEntityManager();
	}
	
	public boolean create(User user){
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			return true;
			
		}finally{
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		try{
			entityManager.getTransaction().begin();
			List<User> users = entityManager.createQuery("from User").getResultList();
			/*
			for(Categoria cat : categorias){
				System.out.println(cat);
			}
			*/
			entityManager.getTransaction().commit();
			return users;
		}finally{
			
			//session.close();
		}
	}
	
	public User find(long id){
		try{
			entityManager.getTransaction().begin();
			return entityManager.find(User.class, id);
			
		}finally{
			entityManager.getTransaction().commit();
			//session.close();
		}
	}
	
	public boolean updateUser(User user, long id){
		try{
			entityManager.getTransaction().begin();
			//session.update(arg0, arg1);
			entityManager.createQuery("UPDATE User u set u.nome = ?1, u.email = ?2, u.senha = ?3 where u.id = ?4")
				.setParameter(1, user.getNome())
				.setParameter(2, user.getEmail())
				.setParameter(3, user.getSenha())
				.setParameter(4, id)
				.executeUpdate();
			entityManager.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}	
	}
	
	public User findEmailSenha(String email, String senha){
		try{
			entityManager.getTransaction().begin();
			return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1 AND u.senha = ?2 ")
				.setParameter(1, email)
				.setParameter(2, senha)
				.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			entityManager.getTransaction().commit();
		}
	;
	return null;
		
	}
	public boolean delete(User user){
		try{
			entityManager.getTransaction().begin();
			entityManager.remove(user);
			entityManager.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}
	}
	public static void main(String[] args) {
		//User user = new User("yuri","yurisilva@gmail.com","123");
		//UserDao userDao = new UserDao();
		//System.out.println(userDao.findEmailSenha("yurisilva@gmail.com", "123"));

	}
	
}