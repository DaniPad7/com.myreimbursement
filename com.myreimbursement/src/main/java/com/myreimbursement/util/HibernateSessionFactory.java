package com.myreimbursement.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			/*sessionFactory = new Configuration().configure().setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
					.setProperty("hibernate.connection.username", "postgres").setProperty("hibernate.connection.password", "Heix#394").buildSessionFactory();*/
		
			sessionFactory = new Configuration().configure().setProperty("hibernate.connection.url", "jdbc:postgresql://r1252021instance.cq13qsblamjj.us-east-2.rds.amazonaws.com:5432/postgres")
					.setProperty("hibernate.connection.username", "postgres").setProperty("hibernate.connection.password", "dudif8337><%287").buildSessionFactory();
		 
		
		}
		else {}
		
		return sessionFactory.getCurrentSession();
		
		
	}

}
