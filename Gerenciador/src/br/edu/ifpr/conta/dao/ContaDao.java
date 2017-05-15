package br.edu.ifpr.conta.dao;


import org.hibernate.Session;

import br.edu.ifpr._config.HibernateUtil;
import br.edu.ifpr.conta.pojo.Conta;
import br.edu.ifpr.mesa.pojo.Mesa;

public class ContaDao {

	private Session session;

	public ContaDao(){
		session = HibernateUtil.getSession().openSession();
	}
	
	public boolean create(Conta conta){
		try{
			session.beginTransaction();
			session.save(conta);
			session.getTransaction().commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			//session.close();
		}
	}
	
	public Conta merge(Conta conta){
		try{
			session.beginTransaction();
			Conta contaRetorno = (Conta) session.merge(conta);
			session.getTransaction().commit();
			return contaRetorno;
		}catch(RuntimeException erro){ 
			System.out.println("ERRO MERGE!");
			throw erro;
		}
		finally{
			//session.close();
		}
	
	}
	
	public Conta find(long id){
		try{
			session.beginTransaction();
			return session.get(Conta.class, id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.getTransaction().commit();
			//session.close();
		}
	}
	
	public Conta buscarContaMesa(Mesa mesa){
 		try{
			session.beginTransaction();
			Conta conta = (Conta) session.createQuery("from Conta p where p.mesa = :mesa and p.ativo = 1")
			.setParameter("mesa", mesa)
			.getSingleResult();
			session.getTransaction().commit();
			return conta;
 		}catch (Exception e) {
 			e.printStackTrace();
 			return null;
		}
		
	}
	
	public boolean delete(Conta conta){
		try{
			session.beginTransaction();
			session.delete(conta);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			//session.close();
		}
	}
	
	public boolean desativarConta(Conta conta){
		try{
			session.beginTransaction();
			session.createQuery("UPDATE Conta c set c.ativo = 0  where c.id = ?1")
			.setParameter(1, conta.getId())
			.executeUpdate();
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean desativarContaMesa(Mesa mesa){
		try{
			session.beginTransaction();
			session.createQuery("UPDATE Conta c set c.ativo = 0  where c.mesa = ?1")
			.setParameter(1, mesa)
			.executeUpdate();
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		ContaDao cDao = new ContaDao();
		
		Mesa mesa = new Mesa();
		mesa.setId(1L);
		
		conta =  cDao.buscarContaMesa(mesa);
		
		System.out.println(conta + "fui");
	}
	
}
