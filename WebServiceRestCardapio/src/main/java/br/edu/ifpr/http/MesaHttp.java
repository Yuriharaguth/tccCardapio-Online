package br.edu.ifpr.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MesaHttp {
	
	private Long id;
	private Long numero;
	private Long ativo;
	
	public MesaHttp(){}
	
	public MesaHttp(Long numero) {
		super();
		this.numero = numero;
	}
	
	public MesaHttp(Long numero, Long ativo) {
		super();
		this.numero = numero;
		this.ativo = ativo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getAtivo() {
		return ativo;
	}

	public void setAtivo(Long ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MesaHttp [id=" + id + "]";
	}
	
}
