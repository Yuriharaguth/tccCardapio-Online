package br.edu.ifpr.conta.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifpr.mesa.pojo.Mesa;

@Entity
@Table(name="conta")
public class Conta {
	
	/*
	 QUANDO UMA MESA É ATIVADA ELA É VINCULADA A UMA CONTA
	*/
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="ativo")
	private Long ativo;
	@ManyToOne
	@JoinColumn(name="id_mesa", nullable=false)
	private Mesa mesa;
    
    public Conta(){}
    
	public Conta(Long ativo, Mesa mesa) {
		super();
		this.ativo = ativo;
		this.mesa = mesa;
	}
	
	public Conta(Long id,Long ativo, Mesa mesa) {
		super();
		this.id = id;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAtivo() {
		return ativo;
	}

	public void setAtivo(Long ativo) {
		this.ativo = ativo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", ativo=" + ativo + ", mesa=" + mesa + "," + "]";
	}
	
	

}
