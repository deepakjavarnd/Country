package com.javarnd.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javarnd.domain.City;
import com.javarnd.domain.Country;
import com.javarnd.domain.Language;
import com.javarnd.domain.Sports;

public class HibernateUtil {

	public static Session getSession() {
		Session session = null;
		Properties prop = null;
		try {

			prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));

			/*
			 * configuration.setProperties(prop);
			 * configuration.addAnnotatedClass(City.class);
			 */

			SessionFactory sessionFactory = new Configuration().mergeProperties(prop).addAnnotatedClass(City.class)
					.addAnnotatedClass(Country.class).addAnnotatedClass(Language.class).addAnnotatedClass(Sports.class)
					.buildSessionFactory();

			// 3. Get Session object
			session = sessionFactory.openSession();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return session;
	}

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
