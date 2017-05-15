package br.edu.ifpr._util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Messages {
	
	public static void messageSucesso(){
		String msg = "Adicionado com Sucesso";
		FacesMessage messageSucesso = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, messageSucesso);
	}
	
	public static void messageError(){
		String msg = "Erro, Tente Novamente!";
		FacesMessage messageError = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, messageError);
	}
	
	public static void messageSucessoRemocao(){
		String msg = "Removido com Sucesso!";
		FacesMessage messageRemove = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, messageRemove);
	}
	
	public static void messageSucessoUpdate(){
		String msg = "Atualizado com Sucesso!!";
		FacesMessage messageSucesso = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, messageSucesso);
	}
	
	public static void messageEscrita(String msg){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, message);
	}
	
	public static void messageEscritaErro(String msg){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, message);
	}
	
}
