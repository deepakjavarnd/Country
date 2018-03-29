package com.javarnd.repository;

import org.hibernate.Session;

import com.javarnd.domain.User;
import com.javarnd.util.HibernateUtil;

public class UserLoginRepositoryImpl implements UserLoginRepository {

	public boolean isAuthenticated(String userName, String password) {
		boolean flag = false;
		Session session = null;
		User user = new User();
		session = HibernateUtil.getSession();
		if (session != null) {

			user = (User) session.get(User.class, userName);
			if (password.equals(user.getPassword())) {
				flag = true;
			}

		}

		return flag;
	}

}
