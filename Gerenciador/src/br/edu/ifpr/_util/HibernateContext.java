package br.edu.ifpr._util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.edu.ifpr._config.HibernateUtil;

public class HibernateContext implements ServletContextListener{

	/*
	 * NÃO DEU CERTO, NÃO ESTA SENDO USADO*/
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getSession().close();		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSession().openSession();
		
	}

}
