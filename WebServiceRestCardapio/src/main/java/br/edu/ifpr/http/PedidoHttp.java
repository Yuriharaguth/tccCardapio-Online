package br.edu.ifpr.http;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.ifpr.repository.entity.Conta;
import br.edu.ifpr.repository.entity.Mesa;

@XmlRootElement
public class PedidoHttp {

	private Long id;
	private Conta conta;
	private List<ItensPedidoHttp> itens;
	private Mesa mesa;
	private ItensPedidoHttp itensSolo;
	private ProdutoHttp pro;
	
	public PedidoHttp(){}

	public PedidoHttp(Conta conta) {
		super();
		this.conta = conta;
	}
	
	public PedidoHttp(Conta conta, List<ItensPedidoHttp> itens) {
		super();
		this.conta = conta;
		this.itens = itens;
	}

	public PedidoHttp(Conta conta, Mesa mesa, ItensPedidoHttp itensSolo) {
		super();
		this.conta = conta;
		this.mesa = mesa;
		this.itensSolo = itensSolo;
	}
	
	public PedidoHttp(ProdutoHttp prod, Mesa mesa) {
		super();
		this.pro = prod;
		this.mesa = mesa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<ItensPedidoHttp> getItens() {
		return itens;
	}

	public void setItens(List<ItensPedidoHttp> itens) {
		this.itens = itens;
	}

	public ItensPedidoHttp getItensSolo() {
		return itensSolo;
	}

	public void setItensSolo(ItensPedidoHttp itensSolo) {
		this.itensSolo = itensSolo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public ProdutoHttp getPro() {
		return pro;
	}

	public void setPro(ProdutoHttp pro) {
		this.pro = pro;
	}

	@Override
	public String toString() {
		return "PedidoHttp [mesa=" + mesa + ", pro=" + pro + "]";
	}
	
}
