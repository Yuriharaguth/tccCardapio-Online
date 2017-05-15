package br.edu.ifpr._util.exceptions;

public class ExceptionDAO extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Problemas na DAO!";
	}
	
}
