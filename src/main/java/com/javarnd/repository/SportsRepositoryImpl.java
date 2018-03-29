package com.javarnd.repository;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javarnd.domain.City;
import com.javarnd.domain.Sports;
import com.javarnd.util.HibernateUtil;

public class SportsRepositoryImpl implements SportsRepository {

	public boolean saveSports(Sports sports) {
		Session session = null;
		Transaction tx = null;
		Integer sportsId = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			sportsId = (Integer) session.save(sports);
			if (sportsId != null) {
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
