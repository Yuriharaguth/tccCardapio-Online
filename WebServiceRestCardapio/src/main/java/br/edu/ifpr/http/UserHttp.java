package br.edu.ifpr.http;

import javax.xml.bind.annotation.XmlRootElement;

//PADRÃO DE PROJETO MEMU

@XmlRootElement
public class UserHttp {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String mesa;
	private String caminhoImg;

	
	public UserHttp(){}
	
	public UserHttp(String nome, String email, String senha, String mesa){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.mesa = mesa;
	}
	
	public UserHttp(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public UserHttp(Long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	
	
	public String getCaminhoImg() {
		return caminhoImg;
	}

	public void setCaminhoImg(String caminhoImg) {
		this.caminhoImg = caminhoImg;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	@Override
	public String toString() {
		return "UserHttp [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", mesa=" + mesa
				+ "]";
	}

}
