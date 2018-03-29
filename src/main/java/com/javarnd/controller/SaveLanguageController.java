package com.javarnd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.domain.Language;
import com.javarnd.service.LanguageService;
import com.javarnd.service.LanguageServiceImpl;

public class SaveLanguageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String languageName = null;
		Language language = null;
		boolean flag = false;
		LanguageService service = null;
		languageName = req.getParameter("languageName");
		language = new Language();
		language.setLanguageName(languageName);
		System.out.println(languageName);
		service = new LanguageServiceImpl();
		flag = service.saveLanguage(language);
		if (flag) {
			req.getRequestDispatcher("success.jsp").forward(req, res);
		}
		else {
			req.getRequestDispatcher("failed.jsp").forward(req, res);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
