package br.edu.ifpr.mesa.thread;

import java.util.List;

import br.edu.ifpr.itenspedido.dao.ItensPedidoDao;
import br.edu.ifpr.itenspedido.pojo.ItensPedido;

public class Consulta implements Runnable{
	
	private List<ItensPedido> listItens;
	private ItensPedidoDao itensDao;

	public Consulta(){}
	
	public Consulta(List<ItensPedido> listItens, ItensPedidoDao itensDao){
		this.listItens = listItens;
		this.itensDao = itensDao;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(30000);
				listItens = itensDao.listarPedidosNaoFeitos();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public List<ItensPedido> getListItens() {
		return listItens;
	}
	public void setListItens(List<ItensPedido> listItens) {
		this.listItens = listItens;
	}
	public ItensPedidoDao getItensDao() {
		return itensDao;
	}
	public void setItensDao(ItensPedidoDao itensDao) {
		this.itensDao = itensDao;
	}

}
