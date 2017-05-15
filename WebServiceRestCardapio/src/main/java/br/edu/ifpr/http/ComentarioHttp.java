package br.edu.ifpr.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComentarioHttp {

	private String nome;
	private String email;
	private String comentario;
	
	public ComentarioHttp(){}

	public ComentarioHttp(String nome, String email, String comentario) {
		super();
		this.nome = nome;
		this.email = email;
		this.comentario = comentario;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
