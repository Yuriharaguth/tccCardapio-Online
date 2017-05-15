package br.edu.ifpr.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifpr._util.exceptions.ExceptionDAO;
import br.edu.ifpr.http.ItensPedidoHttp;
import br.edu.ifpr.http.PedidoHttp;
import br.edu.ifpr.repository.dao.ContaDao;
import br.edu.ifpr.repository.dao.ItensPedidoDao;
import br.edu.ifpr.repository.dao.PedidoDao;
import br.edu.ifpr.repository.dao.ProdutoDao;
import br.edu.ifpr.repository.entity.Conta;
import br.edu.ifpr.repository.entity.ItensPedido;
import br.edu.ifpr.repository.entity.Pedido;
import br.edu.ifpr.repository.entity.Produto;

@Path("/pedido")
public class ServiceControllerPedido {
	
	/*		status 1 = aguardadando
	 * 		status 2 = producao 
	 * 		status 3 = pronto
	 * 		status 4 = cancelado
	 */
	
	// MESA -> CONTA -> PEDIDO -> ITENSPEDIDO -> PRODUTO
	@POST 
	@Path("/pedido")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setPedido(PedidoHttp ped){
	
		System.out.println(ped);
		
		try{
			
			ContaDao contaDao = new ContaDao();
			PedidoDao pedidoDao = new PedidoDao();
			
			Pedido pedido = new Pedido();
			Conta conta = new Conta();
			
			//buscando a conta atual da mesa
			conta = contaDao.findContaAtual(ped.getMesa());
			System.out.println(conta + " conta que buscamos ");
			
			
			//vinculando conta com pedido
			pedido.setConta(conta);
			System.out.println(pedido + " pedido que sera salvo");
			
			//salvando pedido
			pedido = pedidoDao.merge(pedido);
			System.out.println(pedido + " pedido SALVo");
			
			//pegando produto
			ProdutoDao produtoDao = new ProdutoDao();
			Produto produto = new Produto();
			System.out.println(ped.getPro() + " pedido SALV0");
			produto = produtoDao.find(ped.getPro().getId());
			
			//salvando item de produto
			ItensPedidoDao itemDao = new ItensPedidoDao();
			ItensPedido item = new ItensPedido(pedido,produto,1,1);
			itemDao.create(item);
			
			return "Pedido realizado com sucesso!";
		}catch (Exception e) {
			// TODO: handle exception
			return "Não foi possivel realizar o seu pedido!";	
		}
		
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getpedido")
	public List<ItensPedidoHttp> getPedidos(){
		
		ItensPedidoDao itensDao = new ItensPedidoDao();
		List<ItensPedido> list = new ArrayList<>();
		List<ItensPedidoHttp> listHttp = new ArrayList<>();
		
		try{
			list = itensDao.listar();
			for(ItensPedido i : list){
				System.out.println(i.getStatus() + ">>>>>>>>>>>");
				
				listHttp.add(new ItensPedidoHttp(i.getId(), i.getQtd(), i.getStatus(),
						i.getProd().getId(), i.getProd().getNome(),i.getPed().getConta().getMesa().getId()));
			}
		}catch (ExceptionDAO e) {
			e.printStackTrace();
		}
		for(ItensPedidoHttp i : listHttp){
			System.out.println(i);
		}
		return listHttp;
	
	}
	
	@POST 
	@Path("/atualizarpedido")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json; charset=UTF-8")
	public List<ItensPedidoHttp> setAtualizarPedido(ItensPedidoHttp i){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(i);
		
		ItensPedidoDao itensDao = new ItensPedidoDao();
		List<ItensPedido> list = new ArrayList<>();
		List<ItensPedidoHttp> listHttp = new ArrayList<>();
	
		
		if(i.getStatus() == 1){
			i.setStatus(2);
		}else if(i.getStatus() == 2){
			i.setStatus(3);
		}else{
			i.setStatus(3);
		}
		
		System.out.println(i.getStatus() + "update >>>>>>>>>>>");
		try{
			 if(itensDao.updateItemPedido(i)){
				list = itensDao.listar();
				for(ItensPedido it : list){
					if(i.getId().equals(it.getId())){
						listHttp.add(new ItensPedidoHttp(it.getId(), it.getQtd(), i.getStatus(),
								it.getProd().getId(), it.getProd().getNome(),it.getPed().getConta().getMesa().getId()));
					}else{
						listHttp.add(new ItensPedidoHttp(it.getId(), it.getQtd(), it.getStatus(),
								it.getProd().getId(), it.getProd().getNome(),it.getPed().getConta().getMesa().getId()));
					}
				}
				 return listHttp;
			 }
		}catch (ExceptionDAO e) {
			e.printStackTrace();
		}
		
		return listHttp;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getpedidofinalizados")
	public List<ItensPedidoHttp> getPedidosFinalizados(){
		ItensPedidoDao itensDao = new ItensPedidoDao();
		List<ItensPedido> list = new ArrayList<>();
		List<ItensPedidoHttp> listHttp = new ArrayList<>();
		
		try{
			list = itensDao.listarFinalizados();
			for(ItensPedido i : list){
				listHttp.add(new ItensPedidoHttp(i.getId(), i.getQtd(), i.getStatus(),
						i.getProd().getId(), i.getProd().getNome(),i.getPed().getConta().getMesa().getId()));
			}
		}catch (ExceptionDAO e) {
			e.printStackTrace();
		}

		return listHttp;
	}
	
}


