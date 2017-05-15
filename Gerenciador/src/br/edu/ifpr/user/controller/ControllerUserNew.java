package br.edu.ifpr.user.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.edu.ifpr._util.Messages;
import br.edu.ifpr._util.exceptions.ExceptionDAO;
import br.edu.ifpr.user.dao.UserDao;
import br.edu.ifpr.user.pojo.User;

@SuppressWarnings("serial")
@ManagedBean(name="userBean")
@ViewScoped
public class ControllerUserNew implements Serializable{
	
	private User user;
	private UserDao userDao;
	private List<User> users;
	
	public ControllerUserNew(){
		userDao = new UserDao();
	}
	
	public void novo(){
		user = new User();
	}
	
	public void salvar(){
		
		try{
			userDao.create(user);
			users = userDao.list();
			Messages.messageEscrita("Usuário salvo!");
		}catch (ExceptionDAO e) {
			e.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void excluir(ActionEvent e){
		try{
			user = (User) e.getComponent().getAttributes().get("userSelecionado");
			userDao.delete(user);
			users = userDao.list();
			Messages.messageEscrita("Usuário Excluído!");
		}catch (ExceptionDAO er) {
			// TODO: handle exception
			er.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	public void editar(ActionEvent e){
		try{
			user = (User) e.getComponent().getAttributes().get("userSelecionado");
			
		}catch (Exception error) {
			error.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}
	
	@PostConstruct
	public void listar(){
		try{
			users = userDao.list();
		}catch (ExceptionDAO e) {
			// TODO: handle exception
			e.printStackTrace();
			Messages.messageEscritaErro("Aconteceu algum erro, tente novamente");
		}
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
