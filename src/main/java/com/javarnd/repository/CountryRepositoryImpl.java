package com.javarnd.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javarnd.domain.Country;
import com.javarnd.util.HibernateUtil;

public class CountryRepositoryImpl implements CountryRepository {

	public boolean saveCountry(Country country) {
		Session session = null;
		Transaction tx = null;
		Integer countryId = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			countryId = (Integer) session.save(country);
			if (countryId != null) {
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

	public List<Country> getCountryInformation() {
		Session session = null;
		List<Country> countryInfo = null;
		List list = null;
		session = HibernateUtil.getSession();
		if (session != null) {

			Criteria criteria = session.createCriteria(Country.class);
			list = criteria.list();

			countryInfo = new ArrayList<Country>();
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				Country country = (Country) itr.next();
				countryInfo.add(country);

			}

		}
		return countryInfo;
	}

}
