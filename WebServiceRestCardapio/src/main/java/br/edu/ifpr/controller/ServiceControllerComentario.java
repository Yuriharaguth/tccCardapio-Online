package br.edu.ifpr.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifpr.http.ComentarioHttp;
import br.edu.ifpr.repository.dao.ComentarioDao;
import br.edu.ifpr.repository.entity.Comentario;

@Path("/comentario")
public class ServiceControllerComentario {
	
	@POST 
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String setComentario(ComentarioHttp comHttp){
		System.out.println(comHttp.toString() + "Chegou!");
		ComentarioDao comDao = new ComentarioDao();
		try{
			Comentario com = new Comentario(comHttp.getNome(),comHttp.getEmail(),comHttp.getComentario());
			comDao.merge(com);
			return "Comentario cadastrado com sucesso!";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "Erro ao cadastrar um registro ";
		}
		
	}

}
