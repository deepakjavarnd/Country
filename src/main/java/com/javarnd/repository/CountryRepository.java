package com.javarnd.repository;

import java.util.List;

import com.javarnd.domain.Country;

public interface CountryRepository {

	public boolean saveCountry(Country country);

	public List<Country> getCountryInformation();

}
