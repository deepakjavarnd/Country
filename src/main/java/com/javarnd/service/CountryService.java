package com.javarnd.service;

import java.util.List;

import com.javarnd.domain.Country;

public interface CountryService {

	public boolean saveCountry(Country country);

	public List<Country> getCountryInformation();
}
