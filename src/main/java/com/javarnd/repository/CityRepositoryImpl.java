package com.javarnd.repository;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javarnd.domain.City;
import com.javarnd.util.HibernateUtil;

public class CityRepositoryImpl implements CityRepository {

	public boolean saveCity(City city) {
		Session session = null;
		Transaction tx = null;
		Integer cityId = null;
		boolean flag = false;
		System.out.println("CityRepositoryImpl");

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			cityId = (Integer) session.save(city);
			if (cityId != null) {
				tx.commit();
				flag = true;
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("Note saved");
		}
		HibernateUtil.closeSession(session);
		return flag;
	}

}
