package br.edu.ifpr.http;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.ifpr.repository.entity.Mesa;

@XmlRootElement
public class ContaHttp {

	private Long id;
	private Long ativo;
	private Mesa mesa;
   
   public ContaHttp(){}
   
	public ContaHttp(Long ativo, Mesa mesa) {
		super();
		this.ativo = ativo;
		this.mesa = mesa;
	}
	
	public ContaHttp(Long id,Long ativo, Mesa mesa) {
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
