package br.edu.ifpr.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itens_pedido")
public class ItensPedido {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_pedido", nullable=false)
	private Pedido ped;
	@ManyToOne
	@JoinColumn(name="id_produto", nullable=false)
	private Produto prod;
	@Column(name="qtd")
	private int qtd;
	@Column(name="status")
	private int status;
	
	public ItensPedido(){}

	public ItensPedido(Pedido ped, Produto prod, int qtd) {
		super();
		this.ped = ped;
		this.prod = prod;
		this.qtd = qtd;
	}
	
	public ItensPedido(Long id, Pedido ped, Produto prod, int qtd) {
		super();
		this.id = id;
		this.ped = ped;
		this.prod = prod;
		this.qtd = qtd;
	}

	public ItensPedido(Pedido ped, Produto prod, int qtd, int status) {
		super();
		this.ped = ped;
		this.prod = prod;
		this.status = status;
		this.qtd = qtd;
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

	@Override
	public String toString() {
		return "ItensPedido [id=" + id + ", ped=" + ped + ", prod=" + prod + ", qtd=" + qtd + "]";
	}

}
