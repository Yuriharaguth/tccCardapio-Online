package br.edu.ifpr.categoria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.edu.ifpr._util.Messages;
import br.edu.ifpr.categoria.dao.CategoriaDao;
import br.edu.ifpr.categoria.pojo.Categoria;

@SuppressWarnings("serial")
@ManagedBean(name="categoriaBean")
@ViewScoped 
public class ControllerCategoriaNew implements Serializable{
	
	private List<Categoria> categorias;
	private Categoria cat;
	private CategoriaDao catDao;
	
	public ControllerCategoriaNew(){
		catDao = new CategoriaDao();
	}
	
	@PostConstruct
	public void listar(){
		try{
			categorias = catDao.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void salvar(){
		try{
			catDao.merge(cat);
			categorias = catDao.list();
			
			Messages.messageEscrita("Categoria salvo!");
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void editar(ActionEvent e){
		
 		try{
 			cat = (Categoria) e.getComponent().getAttributes().get("categoriaSelecionado");
		}catch (Exception error) {
			error.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	public CategoriaDao getCatDao() {
		return catDao;
	}
	public void setCatDao(CategoriaDao catDao) {
		this.catDao = catDao;
	}
	

}
