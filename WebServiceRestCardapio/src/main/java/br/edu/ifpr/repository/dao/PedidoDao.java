package br.edu.ifpr.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpr._util.HibernateUtil;
import br.edu.ifpr.repository.entity.Conta;
import br.edu.ifpr.repository.entity.Mesa;
import br.edu.ifpr.repository.entity.Pedido;

public class PedidoDao {
	
	private EntityManager entityManager;
	
	public PedidoDao(){
		entityManager = HibernateUtil.getEntityManager();
	}
	
	public Pedido merge(Pedido pedido){
		try{
			entityManager.getTransaction().begin();
			pedido = entityManager.merge(pedido);
			entityManager.getTransaction().commit();
			return pedido;
		}catch (Exception e) {
			e.getStackTrace();
			return pedido;
		}
		
	}
	
	public Pedido create(Pedido pedido){
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(pedido);
			entityManager.getTransaction().commit();
			return pedido;
		}catch (Exception e) {
			e.getStackTrace();
			return pedido;
		}
		
	}
	
	public Pedido find(long id){
		try{
			entityManager.getTransaction().begin();
			return entityManager.find(Pedido.class, id);
		}finally{
			entityManager.getTransaction().commit();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> listarPorConta(Conta conta){
		
		try{
			entityManager.getTransaction().begin();
			List<Pedido> lista = entityManager.createQuery("from Pedido p where p.conta = :conta ")
					.setParameter("conta", conta)
					.getResultList();
			entityManager.getTransaction().commit();
			return lista;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		ContaDao cDao = new ContaDao();
		
		Mesa mesa = new Mesa();
		mesa.setId(1L);
		
		conta =  cDao.findContaAtual(mesa);
		
		PedidoDao pDao = new PedidoDao();
		Pedido pedido = new Pedido();
		
		pedido.setConta(conta);
		pedido = pDao.merge(pedido);
		
		System.out.println(pedido);
	}
	
	
}
