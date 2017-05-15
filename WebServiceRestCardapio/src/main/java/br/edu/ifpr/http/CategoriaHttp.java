package br.edu.ifpr.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CategoriaHttp {

	private Long id;
	private String nome;
	private String descricao;
	
	public CategoriaHttp(){}
	
	public CategoriaHttp(Long id){
		this.id = id;
	}
	
	public CategoriaHttp(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public CategoriaHttp(Long id, String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
}
