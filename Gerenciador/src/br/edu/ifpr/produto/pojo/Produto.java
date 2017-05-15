package br.edu.ifpr.produto.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifpr.categoria.pojo.Categoria;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="descricao")
	private String descricao;
	@Column(name="valor", nullable=false, precision = 6, scale=2)
	private BigDecimal valor;
	@Column(name="qtd")
	private int qtd;
	@ManyToOne
	@JoinColumn(name="id_categoria", nullable=false)
	private Categoria cat;
	@Column(name="img",length=5000)
	private String caminhoImg;
	@Lob
	@Column(name = "img_bytes")
	private byte[] imgBytes;


	public Produto(){}
	
	public Produto(String nome, String descricao, BigDecimal valor, int qtd, Categoria cat) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.qtd = qtd;
		this.cat = cat;
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
