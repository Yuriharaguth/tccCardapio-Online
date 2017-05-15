package br.edu.ifpr.http;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.ifpr.repository.entity.Categoria;

@XmlRootElement
public class ProdutoHttp {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private int qtd;
	private Categoria cat;
	private String caminhoImg;
	private byte[] imgBytes;


	public ProdutoHttp(){}
	
	public ProdutoHttp(Long id) {
		super();
		this.id = id;
	}

	public ProdutoHttp(Long id, String nome, String descricao, BigDecimal valor, int qtd, Categoria cat) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.qtd = qtd;
		this.cat = cat;
	}
	
	public ProdutoHttp(Long id, String nome, String descricao, BigDecimal valor, int qtd,
			Categoria cat, String caminhoImg) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.qtd = qtd;
		this.cat = cat;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal d) {
		this.valor = d;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	public String getCaminhoImg() {
		return caminhoImg;
	}
	public void setCaminhoImg(String caminhoImg) {
		this.caminhoImg = caminhoImg;
	}
	public byte[] getImgBytes() {
		return imgBytes;
	}
	public void setImgBytes(byte[] imgBytes) {
		this.imgBytes = imgBytes;
	}


	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + ", qtd=" + qtd
				+ ", cat=" + cat + "]";
	}
	
}
