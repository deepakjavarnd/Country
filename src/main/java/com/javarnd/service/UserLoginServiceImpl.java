package com.javarnd.service;

import com.javarnd.repository.UserLoginRepository;
import com.javarnd.repository.UserLoginRepositoryImpl;

public class UserLoginServiceImpl implements UserLoginService {
	private UserLoginRepository userLoginRepository = null;

	public boolean isAuthenticated(String userName, String password) {
		userLoginRepository = new UserLoginRepositoryImpl();
		return userLoginRepository.isAuthenticated(userName, password);
	}

}
