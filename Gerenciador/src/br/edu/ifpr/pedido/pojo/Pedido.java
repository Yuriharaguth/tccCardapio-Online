package br.edu.ifpr.pedido.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifpr.conta.pojo.Conta;


@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
    @JoinColumn(name = "conta_id", nullable=false)
	private Conta conta;
	@Column(name="status")
	private Long status;
	
	public Pedido(){}

	public Pedido(Conta conta) {
		super();
		this.conta = conta;
	}
	
	public Pedido(Conta conta, Long status) {
		super();
		this.conta = conta;
		this.status = status;
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

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", conta=" + conta + "]";
	}
		
}
