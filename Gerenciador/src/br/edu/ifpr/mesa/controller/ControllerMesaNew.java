package br.edu.ifpr.mesa.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.edu.ifpr.conta.dao.ContaDao;
import br.edu.ifpr.conta.pojo.Conta;
import br.edu.ifpr.itenspedido.dao.ItensPedidoDao;
import br.edu.ifpr.itenspedido.pojo.ItensPedido;
import br.edu.ifpr.mesa.dao.MesaDao;
import br.edu.ifpr.mesa.pojo.Mesa;
import br.edu.ifpr.mesa.thread.Consulta;
import br.edu.ifpr.pedido.dao.PedidoDao;
import br.edu.ifpr.pedido.pojo.Pedido;

@SuppressWarnings("serial")
@ManagedBean(name="mesaBean")
@ViewScoped 
public class ControllerMesaNew implements Serializable{
	
	private Mesa mesa;
	private List<Mesa> listMesa;
	private MesaDao mesaDao;
	private Conta conta;
	private ContaDao contaDao;
	private List<Pedido> listPedido;
	private PedidoDao pedidoDao;
	private ItensPedidoDao itensDao;
	private List<ItensPedido> listItens;
	private List<ItensPedido> listItensConta;
	
	private BigDecimal totalValor;
	private Double resultado;
	


	public ControllerMesaNew(){
		mesaDao = new MesaDao();
		itensDao = new ItensPedidoDao();
		listMesa = new ArrayList<Mesa>();
		contaDao = new ContaDao();
		listPedido = new ArrayList<Pedido>();
		pedidoDao = new PedidoDao();
		listItensConta = new ArrayList<ItensPedido>();
		resultado = new Double(1);
	}
	
	@PostConstruct
	public void listar(){
		try{
			listMesa = mesaDao.listAtiva();
			listItens = itensDao.listarPedidosNaoFeitos();
			/*//== 1 ? 'Aguardando':'Produção
			
			for(ItensPedido i: listItens){
				System.out.println(i);
			}*/
			
			
		}catch (Exception e) {
			System.out.println("Erro Carregar Lista");
			e.printStackTrace();
		}
	}
	
	
	// MESA -> CONTA -> PEDIDO -> ITENSPEDIDO -> PRODUTO
	
	public void fecharConta(ActionEvent e){
		
		totalValor = new BigDecimal("0.00");
		
		mesa = (Mesa) e.getComponent().getAttributes().get("mesaSelecionado");

		conta = contaDao.buscarContaMesa(mesa);
		
		System.out.println(conta + " numero conta");

		listPedido = pedidoDao.listarPorConta(conta);

		System.out.println(listPedido.size() + " qtd pedidos");
		
		
		for(Pedido pedido : listPedido){
			System.out.println("111111");
			listItensConta.addAll(itensDao.listarPorPedido(pedido));
		}
		
		for(ItensPedido item : listItensConta){
			System.out.println(item.getProd().getValor() + "Valor do pedido");
			
			totalValor = totalValor.add(item.getProd().getValor()) ;
			
			//totalValor.add(item.getProd().getValor());
			System.out.println(totalValor + "vALOR tOTAL");
		}
		System.out.println(totalValor + "vALOR tOTAL");
	}
	
	public void fecharContaCalc(){
		
	}
	
	
	
	
	
	
	
	public void atualisarListaPedidos(){
		System.out.println("oioioi 1111");
		listar();		
	}
	
	public void atualisarListaMesas(){
		System.out.println("oioioi 2222");
		listar();
	}

	public void start(List<ItensPedido> listItens, ItensPedidoDao itensDao){
		consulta = new Consulta(listItens, itensDao);
		
		Thread thread = new Thread(consulta);
		
		thread.start();
	
	}
	
	public void atualizar(){
		listItens = consulta.getListItens();
	}
	
	//geters seters
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public List<Mesa> getListMesa() {
		return listMesa;
	}
	public void setListMesa(List<Mesa> listMesa) {
		this.listMesa = listMesa;
	}
	public MesaDao getMesaDao() {
		return mesaDao;
	}
	public void setMesaDao(MesaDao mesaDao) {
		this.mesaDao = mesaDao;
	}
	public ItensPedidoDao getItensDao() {
		return itensDao;
	}
	public void setItensDao(ItensPedidoDao itensDao) {
		this.itensDao = itensDao;
	}
	public List<ItensPedido> getListItens() {
		return listItens;
	}
	public void setListItens(List<ItensPedido> listItens) {
		this.listItens = listItens;
	}
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public ContaDao getContaDao() {
		return contaDao;
	}

	public void setContaDao(ContaDao contaDao) {
		this.contaDao = contaDao;
	}

	public List<Pedido> getListPedido() {
		return listPedido;
	}

	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}

	public PedidoDao getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

	public List<ItensPedido> getListItensConta() {
		return listItensConta;
	}

	public void setListItensConta(List<ItensPedido> listItensConta) {
		this.listItensConta = listItensConta;
	}
	private Consulta consulta;
	

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public BigDecimal getTotalValor() {
		return totalValor;
	}

	public void setTotalValor(BigDecimal totalValor) {
		this.totalValor = totalValor;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	
	
}
