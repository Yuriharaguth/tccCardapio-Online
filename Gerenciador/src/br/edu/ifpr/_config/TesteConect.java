package br.edu.ifpr._config;

import org.hibernate.Session;

public class TesteConect {

	public static void main(String[] args) {
		Session sessao = null;
		try{
			sessao = HibernateUtil.getSession().openSession();
			System.out.println("Conectou");
		}finally{
			sessao.close();
			System.out.println("Fechou!");
		}

	}

}
