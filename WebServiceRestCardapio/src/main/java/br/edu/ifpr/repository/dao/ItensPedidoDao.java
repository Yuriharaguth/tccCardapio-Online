package br.edu.ifpr.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr._util.exceptions.ExceptionDAO;
import br.edu.ifpr.http.ItensPedidoHttp;
import br.edu.ifpr.repository.entity.ItensPedido;
import br.edu.ifpr.repository.entity.Pedido;

public class ItensPedidoDao {
	
	private EntityManager entityManager;
	
	public ItensPedidoDao(){
		entityManager = HibernateUtil.getEntityManager();
	}

	public boolean create(ItensPedido item){
		try{
			System.out.println(item);
			entityManager.getTransaction().begin();
			entityManager.merge(item);
			entityManager.getTransaction().commit();
			return true;
			
		}finally{
			//entityManager.close();
		}
	}
	
	public ItensPedido find(long id){
		try{
			entityManager.getTransaction().begin();
			return entityManager.find(ItensPedido.class, id);
		}finally{
			entityManager.getTransaction().commit();
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ItensPedido> listarPorPedido(Pedido pedido){
		
		try{
			entityManager.getTransaction().begin();
			List<ItensPedido> lista = entityManager.createQuery("from ItensPedido p where p.ped = :pedido ")
					.setParameter("conta", pedido)
					.getResultList();
			entityManager.getTransaction().commit();
			return lista;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ItensPedido> listar() throws ExceptionDAO{
		try{
	
			entityManager.getTransaction().begin();
			List<ItensPedido> itens = entityManager.createQuery("from ItensPedido i where (i.status = 1 or i.status = 2) ").getResultList();
			entityManager.getTransaction().commit();
			
			return itens;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO();
		}
		
	}
	
	public boolean updateItemPedido(ItensPedidoHttp i) throws ExceptionDAO{
		try{
			entityManager.getTransaction().begin();
			entityManager.createQuery("UPDATE ItensPedido i set i.status = ?1 where i.id = ?2")
				.setParameter(1, i.getStatus())
				.setParameter(2, i.getId())
				.executeUpdate();
			entityManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ItensPedido> listarFinalizados() throws ExceptionDAO{
		try{
	
			entityManager.getTransaction().begin();
			List<ItensPedido> itens = entityManager.createQuery("from ItensPedido i where i.status = 3 ").getResultList();
			entityManager.getTransaction().commit();
			
			return itens;
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO();
		}
		
	}
	/*		listarFinalizados
	 * 		status 1 = aguardadando
	 * 		status 2 = producao 
	 * 		status 3 = pronto
	 * 		status 4 = cancelado
	 */
	
}
