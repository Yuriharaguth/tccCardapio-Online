package br.edu.ifpr.http;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.ifpr.repository.entity.Pedido;
import br.edu.ifpr.repository.entity.Produto;

@XmlRootElement
public class ItensPedidoHttp {

	private Long id;
	private Pedido ped;
	private Produto prod;
	private int qtd;
	private int status;
	private long idProduto;
	private String nomeProduto;
	private Long numeroMesa;
	
	public ItensPedidoHttp(){}

	public ItensPedidoHttp(Pedido ped, Produto prod, int qtd) {
		super();
		this.ped = ped;
		this.prod = prod;
		this.qtd = qtd;
	}

	public ItensPedidoHttp(Long id, Pedido ped, Produto prod, int qtd) {
		super();
		this.id = id;
		this.ped = ped;
		this.prod = prod;
		this.qtd = qtd;
	}

	public ItensPedidoHttp(Long id, int qtd, int status, long idProduto, String nomeProduto, Long numeroMesa) {
		super();
		this.id = id;
		this.qtd = qtd;
		this.status = status;
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.numeroMesa = numeroMesa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPed() {
		return ped;
	}

	public void setPed(Pedido ped) {
		this.ped = ped;
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Long getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(Long numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	@Override
	public String toString() {
		return "ItensPedidoHttp [id=" + id + ", ped=" + ped + ", prod=" + prod + ", qtd=" + qtd + ", status=" + status
				+ ", idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + "]";
	}

}
