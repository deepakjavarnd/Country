package com.javarnd.repository;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javarnd.domain.City;
import com.javarnd.domain.Language;
import com.javarnd.util.HibernateUtil;

public class LanguageRepositoryImpl implements LangaugeRepository {

	public boolean saveLanguage(Language language) {
		Session session = null;
		Transaction tx = null;
		Integer langiageId = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			langiageId = (Integer) session.save(language);
			if (langiageId != null) {
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
