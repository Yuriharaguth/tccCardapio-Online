package br.edu.ifpr.mesa.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mesa")
public class Mesa {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="numero")
	private Long numero;
	@Column(name="ativo")
	private Long ativo;
	
	public Mesa(){}
	
	public Mesa(Long numero) {
		super();
		this.numero = numero;
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
		return "Mesa [id=" + id + ", numero=" + numero + ", ativo=" + ativo + "]";
	}
	
	
}
