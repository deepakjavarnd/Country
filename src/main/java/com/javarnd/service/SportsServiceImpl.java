package com.javarnd.service;

import com.javarnd.domain.Sports;
import com.javarnd.repository.SportsRepository;
import com.javarnd.repository.SportsRepositoryImpl;

public class SportsServiceImpl implements SportsService {

	private SportsRepository sportsRepository;

	public boolean saveSports(Sports sports) {
		boolean flag = false;
		sportsRepository = new SportsRepositoryImpl();
		flag = sportsRepository.saveSports(sports);
		return flag;
	}

}
