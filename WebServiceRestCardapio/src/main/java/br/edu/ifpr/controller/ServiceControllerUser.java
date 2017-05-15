package br.edu.ifpr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifpr.http.UserHttp;
import br.edu.ifpr.repository.dao.UserDao;
import br.edu.ifpr.repository.entity.User;

@Path("/user")
public class ServiceControllerUser {

	private final UserDao userDao = new UserDao();
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/users")
	public List<UserHttp> getUsers(){
		
		List<UserHttp> listUserHttp = new ArrayList<UserHttp>();
		List<User> users = userDao.list();
		
		for(User user : users){
			listUserHttp.add(new UserHttp(user.getId(), user.getNome(),user.getEmail(), user.getSenha()));
		}
		
		return listUserHttp;
	}
	
	@POST 
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String CadatrarUser(UserHttp userHttp){
			
			try{
				User user = new User(userHttp.getNome(),userHttp.getEmail(),userHttp.getSenha());
				userDao.create(user);
				return "Usuario cadastrado com sucesso!";
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return "Erro ao cadastrar um registro ";
			}
	}

}
