package br.edu.ifpr.mesa.dao;

import java.util.List;

import org.hibernate.Session;

import br.edu.ifpr._config.HibernateUtil;
import br.edu.ifpr.mesa.pojo.Mesa;

public class MesaDao {
	
	private Session session;
	
	public MesaDao(){
		session = HibernateUtil.getSession().openSession();
	}
	
	public boolean create(Mesa mesa){
		try{
			session.beginTransaction();
			session.merge(mesa);
			session.getTransaction().commit();
			return true;
			
		}finally{
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> list(){
		try{
			session.beginTransaction();
			List<Mesa> mesas = session.createQuery("from Mesa").getResultList();
			session.getTransaction().commit();
			return mesas;
		}finally{

		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> listAtiva(){
		try{
			session.beginTransaction();
			List<Mesa> mesas = session.createQuery("from Mesa m where m.ativo = 1").getResultList();
			session.getTransaction().commit();
			return mesas;
		}finally{

		}
		
	}
	
	public Mesa find(long id){
		try{
			session.beginTransaction();
			Mesa mesa = session.find(Mesa.class, id);
			return mesa;
		}catch (Exception e) {
			e.getMessage();
			return null;
		}
		finally{
			session.getTransaction().commit();
		}
	}
	
	public boolean updateMesa( Mesa mesa ){
		try{
			session.beginTransaction();
			System.out.println(mesa.toString() + "testeupdate");
			session.createQuery("UPDATE Mesa m set m.ativo = ?1 where m.id = ?2")
				.setParameter(1, mesa.getAtivo())
				.setParameter(2, mesa.getId())
				.executeUpdate();
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.getMessage();
			return false;
		}
		finally{
			//session.close();
		}	
	}
	
	public static void main(String[] args) {
		/*Mesa mesa = new Mesa();
		List<Mesa> listMesa = new ArrayList<Mesa>();
		MesaDao mDao = new MesaDao();
		
		mesa =  mDao.find(5);
		
		listMesa = mDao.listAtiva();		
		System.out.println(listMesa.size());
		*/

	}

}
