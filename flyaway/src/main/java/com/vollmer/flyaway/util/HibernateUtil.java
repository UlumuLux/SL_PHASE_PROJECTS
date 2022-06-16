package com.vollmer.flyaway.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.vollmer.flyaway.dto.Airline;
import com.vollmer.flyaway.dto.Destination;
import com.vollmer.flyaway.dto.Flight;
import com.vollmer.flyaway.dto.Source;
import com.vollmer.flyaway.dto.User;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/flyaway?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS,  "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "false");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				
				config.setProperties(settings);
				config.addAnnotatedClass(User.class);
				config.addAnnotatedClass(Flight.class);
				config.addAnnotatedClass(Source.class);
				config.addAnnotatedClass(Destination.class);
				config.addAnnotatedClass(Airline.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties()).build();
				sessionFactory = config.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
