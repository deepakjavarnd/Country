package com.javarnd.service;

import com.javarnd.domain.Language;
import com.javarnd.repository.LangaugeRepository;
import com.javarnd.repository.LanguageRepositoryImpl;

public class LanguageServiceImpl implements LanguageService {

	private LangaugeRepository languageRepository;

	public boolean saveLanguage(Language language) {
		boolean flag = false;
		languageRepository = new LanguageRepositoryImpl();
		flag = languageRepository.saveLanguage(language);
		return flag;
	}

}
