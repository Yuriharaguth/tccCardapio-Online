package br.edu.ifpr.user.dao;

import java.util.List;

import org.hibernate.Session;

import br.edu.ifpr._config.HibernateUtil;
import br.edu.ifpr._util.exceptions.ExceptionDAO;
import br.edu.ifpr.user.pojo.User;

public class UserDao {

	private Session session;

	public UserDao(){
		session = HibernateUtil.getSession().openSession();
	}
	
	public boolean create(User user) throws ExceptionDAO{
		try{
			session.beginTransaction();
			session.merge(user);
			session.getTransaction().commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list() throws ExceptionDAO {
		try{
			session.beginTransaction();
			List<User> users = session.createQuery("from User").getResultList();
			session.getTransaction().commit();
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO();
		}
	}
	
	public User find(long id) throws ExceptionDAO{
		try{
			session.beginTransaction();
			return session.get(User.class, id);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO();
		}
		
	}
	
	public boolean updateUser(User user, long id){
		try{
			session.beginTransaction();
			//session.update(arg0, arg1);
			session.createQuery("UPDATE User u set u.nome = ?1, u.email = ?2, u.senha = ?3 where u.id = ?4")
				.setParameter(1, user.getNome())
				.setParameter(2, user.getEmail())
				.setParameter(3, user.getSenha())
				.setParameter(4, id)
				.executeUpdate();
			session.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}	
	}
	
	public boolean delete(User user){
		try{
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			return true;
		}finally{
			//session.close();
		}
	}
	public static void main(String[] args) {
		//User user = new User("yuri","haraguths@gmail.com","123");
		//UserDao userDao = new UserDao();
		//userDao.create(user);

	}

}
