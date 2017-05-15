package br.edu.ifpr.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifpr.http.UserHttp;
import br.edu.ifpr.repository.dao.ContaDao;
import br.edu.ifpr.repository.dao.MesaDao;
import br.edu.ifpr.repository.dao.UserDao;
import br.edu.ifpr.repository.entity.Conta;
import br.edu.ifpr.repository.entity.Mesa;
import br.edu.ifpr.repository.entity.User;


@Path("/login")
public class ServiceControllerLogin {
	
	private final UserDao userDao = new UserDao();
	private final MesaDao mesaDao = new MesaDao();
	
	@POST 
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserHttp loginUser(UserHttp userHttp){
		
		System.out.println(userHttp.toString() + "CHEGOU!");
		
		User u ;
		UserHttp uHttp;
		Mesa mesa;
		
			try{
				//Verifica login de usuario
				u = userDao.findEmailSenha(userHttp.getEmail(), userHttp.getSenha());
				
				//verifica existencia da mesa
				mesa = mesaDao.find(Long.parseLong(userHttp.getMesa()));
				System.out.println(mesa + "retorno");
				
				//atualização da mesa como ativa
				mesa.setAtivo(1l);
				mesaDao.updateMesa(mesa);
				System.out.println(mesa + "atualizada");
			
				//obj de retorno, obj user + numero da mesa
				uHttp = new UserHttp(u.getNome(),u.getEmail(),u.getSenha(),Long.toString(mesa.getNumero()));
				System.out.println(uHttp.toString() + "SAIDA!");
				
				ContaDao contaDao = new ContaDao();
				Conta conta = new Conta();
				conta.setAtivo(1l);
				conta.setMesa(mesa);
				contaDao.desativarContaMesa(mesa);
				contaDao.merge(conta);
				
				
				return uHttp;
			}catch (Exception e) {
				e.getMessage();
				return uHttp = null;
			}
	}
	
	@POST 
	@Path("/cozinha")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserHttp loginCozinha(UserHttp userHttp){
		System.out.println(userHttp.toString() + "CHEGOU!");
		
		User u ;
		UserHttp uHttp;
		
			try{
				//Verifica login de usuario
				u = userDao.findEmailSenha(userHttp.getEmail(), userHttp.getSenha());
				//obj de retorno, obj user + numero da mesa
				uHttp = new UserHttp(u.getNome(),u.getEmail(),u.getSenha());
				System.out.println(uHttp.toString() + "SAIDA!");
				
				return uHttp;
			}catch (Exception e) {
				e.getMessage();
				return uHttp = null;
			}
		
	}

}
