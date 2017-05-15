package br.edu.ifpr.pedido.dao;

import java.util.List;

import org.hibernate.Session;

import br.edu.ifpr._config.HibernateUtil;
import br.edu.ifpr.conta.dao.ContaDao;
import br.edu.ifpr.conta.pojo.Conta;
import br.edu.ifpr.itenspedido.dao.ItensPedidoDao;
import br.edu.ifpr.itenspedido.pojo.ItensPedido;
import br.edu.ifpr.mesa.dao.MesaDao;
import br.edu.ifpr.mesa.pojo.Mesa;
import br.edu.ifpr.pedido.pojo.Pedido;



public class PedidoDao {
	
	private Session session;

	public PedidoDao(){
		session = HibernateUtil.getSession().openSession();
	}
	
	public boolean create(Pedido ped){
		try{
			session.beginTransaction();
			session.save(ped);
			session.getTransaction().commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> list(){
		try{
			session.beginTransaction();
			List<Pedido> pedidos = session.createQuery("from Pedido").getResultList();
			
			//teste
			for(Pedido cat : pedidos){
				System.out.println(cat);
			}
			
			session.getTransaction().commit();
			return pedidos;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			//session.close();
		}
	}
	
	public Pedido find(long id){
		try{
			session.beginTransaction();
			return session.get(Pedido.class, id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.getTransaction().commit();
			//session.close();
		}
	}
	
	public boolean delete(Pedido ped){
		try{
			session.beginTransaction();
			session.delete(ped);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			//session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> listarPorConta(Conta conta){
		try{
			session.beginTransaction();

			List<Pedido> pedidos = session.createQuery("from Pedido p where p.conta = :conta ")
					.setParameter("conta", conta)
					.getResultList();
			
			session.getTransaction().commit();
			return pedidos;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}
	
	public static void main(String[] args) {
		/*
		//pegando a mesa
		MesaDao mesaDao = new MesaDao();
		Mesa mesa = mesaDao.find(1);
		
		//criando conta
		ContaDao contaDao = new ContaDao();
		Conta conta = new Conta(1l,mesa);
		contaDao.create(conta);
		
		//criando pedido
		PedidoDao pedDao = new PedidoDao();
		Pedido pedido = new Pedido(conta);
		pedDao.create(pedido);
		
		//criando item de pedido
		ProdutoDao prodDao = new ProdutoDao();
		Produto prod = prodDao.find(122l);
		ItensPedidoDao itensDao = new ItensPedidoDao();
		ItensPedido item = new ItensPedido(pedido,prod,5);
		*/
		
		//pegando a mesa
		MesaDao mesaDao = new MesaDao();
		Mesa mesa = mesaDao.find(1);
		System.out.println(mesa);
		
		//pegando a conta da mesa
		ContaDao contaDao = new ContaDao();
		Conta conta = contaDao.buscarContaMesa(mesa);
		System.out.println(conta);
		
		//pegando os pedidos pela conta
		PedidoDao pedDao = new PedidoDao();
		List<Pedido> pedidos = pedDao.listarPorConta(conta);
		for(Pedido ped : pedidos){
			System.out.println(ped+"oi");
		}
		
		Pedido peds = pedDao.find(165l);
		//ProdutoDao pDao = new ProdutoDao();
		//Produto prod = pDao.find(141);
		ItensPedidoDao iDao = new ItensPedidoDao();
		//ItensPedido i = new ItensPedido(peds, prod, 2);
		//iDao.create(i);
		
		List<ItensPedido> listaItens = iDao.listarPorPedido(peds);
		for(ItensPedido it : listaItens){
			System.out.println(it+"oi");
		}
		//
		
	}
	
	
}
