package br.edu.ifpr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifpr._util.exceptions.ExceptionDAO;
import br.edu.ifpr.http.ProdutoHttp;
import br.edu.ifpr.repository.dao.ProdutoDao;
import br.edu.ifpr.repository.entity.Categoria;
import br.edu.ifpr.repository.entity.Produto;

@Path("/produto")
public class ServiceControllerProduto {
	
	private final ProdutoDao prodDao = new ProdutoDao();
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/produtos")
	public List<ProdutoHttp> getProduto(){
		List<ProdutoHttp> listProdHttp = new ArrayList<ProdutoHttp>();
		
		try{
			List<Produto> prods = prodDao.list();
			for(Produto prod : prods){
				listProdHttp.add(new ProdutoHttp(prod.getId(),prod.getNome(), 
						prod.getDescricao(), prod.getValor(), prod.getQtd(), prod.getCat()));
			}
			return listProdHttp;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return listProdHttp;
		}
	}
	
	@POST 
	@Path("/produtocategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoHttp> getProdutoCategoria(Categoria cat){
		
		List<ProdutoHttp> listProdHttp = new ArrayList<ProdutoHttp>();
		
		try{
			List<Produto> prods = prodDao.listPorCategoria(cat);
			for(Produto prod : prods){
				System.out.println(prod.getId());
				listProdHttp.add(new ProdutoHttp(prod.getId(),prod.getNome(), 
						prod.getDescricao(), prod.getValor(), prod.getQtd(), prod.getCat(),prod.getCaminhoImg()));
			}
			return listProdHttp;
		}catch (ExceptionDAO e) {
			System.out.println(e.getMessage());
			return listProdHttp = null;
		}

	}
	
}
