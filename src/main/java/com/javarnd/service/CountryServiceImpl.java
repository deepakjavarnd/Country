package com.javarnd.service;

import java.util.List;

import com.javarnd.domain.Country;
import com.javarnd.repository.CountryRepository;
import com.javarnd.repository.CountryRepositoryImpl;

public class CountryServiceImpl implements CountryService {

	private CountryRepository countryRepository;

	public boolean saveCountry(Country country) {
		boolean flag = false;
		countryRepository = new CountryRepositoryImpl();
		flag = countryRepository.saveCountry(country);
		return flag;
	}

	@Override
	public List<Country> getCountryInformation() {
		List<Country> country = null;
		countryRepository = new CountryRepositoryImpl();
		country = countryRepository.getCountryInformation();
		return country;
	}

}
