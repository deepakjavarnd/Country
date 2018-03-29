package com.javarnd.repository;

public interface UserLoginRepository {
	public boolean isAuthenticated(String userName, String password);

}
