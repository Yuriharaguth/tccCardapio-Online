package br.edu.ifpr.produto.controller;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.edu.ifpr._util.ByteImagem;
import br.edu.ifpr._util.Messages;
import br.edu.ifpr.categoria.dao.CategoriaDao;
import br.edu.ifpr.categoria.pojo.Categoria;
import br.edu.ifpr.produto.dao.ProdutoDao;
import br.edu.ifpr.produto.pojo.Produto;

@SuppressWarnings("serial")
@ManagedBean(name="produtoBean")
@ViewScoped 
public class ControllerProdutoNew implements Serializable{

	private Produto produto;
	private List<Produto> produtos;
	private ProdutoDao prodDao;
	private CategoriaDao catDao;
	private List<SelectItem> categorias;
	
	private String caminho;
	private Long idCategoria;
	
	public ControllerProdutoNew(){
		prodDao = new ProdutoDao();
		catDao = new CategoriaDao();
	}
	
	@PostConstruct
	public void listar(){
		try{
			produtos = prodDao.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void novo(){
		try{
			produto = new Produto();
			listCategorias();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}

	}
	
	public void listCategorias(){
		categorias = new ArrayList<SelectItem>();
		for(Categoria c : catDao.list()){
			categorias.add(new SelectItem(c.getId(), c.getNome()));
		}
	}
	
	
	public void salvar(){
		try{
			/*Transformando a img num array de bytes*/
			produto.setImgBytes((ByteImagem.convertImgToByte(caminho)));	
			produto.setCat(catDao.find(idCategoria));
			
			Produto retorno = prodDao.merge(produto);
			
			Path origem = Paths.get(caminho);
			Path destino = Paths.get("C:/uploads/" + retorno.getId() + ".jpg");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
			
			produto = new Produto();
			produtos = prodDao.list();
			
			Messages.messageEscrita("Produto salvo!");
		}catch (RuntimeException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void excluir(ActionEvent e){
		try{
			produto = (Produto) e.getComponent().getAttributes().get("produtoSelecionado");
			prodDao.delete(produto);
			listCategorias();
			Messages.messageEscrita("Produto Excluído!");
		}catch (RuntimeException erro) {
			// TODO: handle exception
			erro.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void editar(ActionEvent e){
	
 		try{
 			produto = (Produto) e.getComponent().getAttributes().get("produtoSelecionado");		
 			listCategorias();
		}catch (Exception error) {
			error.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void uploadFoto(FileUploadEvent event){
		try{
			UploadedFile arquivoUpload = event.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			caminho = arquivoTemp.toString();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ocorreu erro ao carregar arquivo!");
			e.printStackTrace();
			
		}
		
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDao getProdDao() {
		return prodDao;
	}

	public void setProdDao(ProdutoDao prodDao) {
		this.prodDao = prodDao;
	}

	public CategoriaDao getCatDao() {
		return catDao;
	}

	public void setCatDao(CategoriaDao catDao) {
		this.catDao = catDao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public List<SelectItem> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<SelectItem> categorias) {
		this.categorias = categorias;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
		
}
