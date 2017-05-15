package br.edu.ifpr._config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory session = buildSession();

	private static SessionFactory buildSession() {
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Problema com o Banco!\n" + e);
			throw new ExceptionInInitializerError();
		}
	
	}

	public static SessionFactory getSession() {
		return session;
	}

}
