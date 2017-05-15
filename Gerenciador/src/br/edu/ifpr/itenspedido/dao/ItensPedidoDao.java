package br.edu.ifpr.itenspedido.dao;

import java.util.List;

import org.hibernate.Session;

import br.edu.ifpr._config.HibernateUtil;
import br.edu.ifpr.itenspedido.pojo.ItensPedido;
import br.edu.ifpr.pedido.pojo.Pedido;

public class ItensPedidoDao {
	
	private Session session;
	
	public ItensPedidoDao(){
		session = HibernateUtil.getSession().openSession();
	}
	
	public boolean create(ItensPedido item){
		try{
			session.beginTransaction();
			session.save(item);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			//session.close();
		}
	}
	
	public ItensPedido merge(ItensPedido item){
		try{
			session.beginTransaction();
			ItensPedido itemRetorno = (ItensPedido) session.merge(item);
			session.getTransaction().commit();
			return itemRetorno;
		}catch(RuntimeException erro){ 
			System.out.println("ERRO MERGE!");
			throw erro;
		}
		finally{
			//session.close();
		}
	}
	
	public ItensPedido find(long id){
		try{
			session.beginTransaction();
			return session.get(ItensPedido.class, id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.getTransaction().commit();
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ItensPedido> listarPorPedido(Pedido pedido){
		try{
			session.beginTransaction();
			List<ItensPedido> itensPedido = session.createQuery("from ItensPedido i where i.ped = :pedido ")
					.setParameter("pedido", pedido)
					.getResultList();	
			session.getTransaction().commit();
			return itensPedido;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public List<ItensPedido> listarPedidosNaoFeitos(){
		try{
			session.beginTransaction();
			List<ItensPedido> itensPedido = session.createQuery("from ItensPedido i where (i.status = 1 or i.status = 2) ")
					.getResultList();
			session.getTransaction().commit();
			return itensPedido;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	

}
