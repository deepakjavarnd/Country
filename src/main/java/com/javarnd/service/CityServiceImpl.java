package com.javarnd.service;

import com.javarnd.domain.City;
import com.javarnd.repository.CityRepository;
import com.javarnd.repository.CityRepositoryImpl;

public class CityServiceImpl implements CityService {

	private CityRepository cityRepository;

	public boolean saveCity(City city) {
		boolean flag = false;
		cityRepository = new CityRepositoryImpl();
		flag = cityRepository.saveCity(city);
		return flag;
	}

}
