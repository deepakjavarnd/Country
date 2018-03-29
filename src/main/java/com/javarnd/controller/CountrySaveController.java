package com.javarnd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.domain.City;
import com.javarnd.domain.Country;
import com.javarnd.service.CountryService;
import com.javarnd.service.CountryServiceImpl;

public class CountrySaveController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String countryName = null;
		Country country = null;
		boolean flag = false;
		CountryService service = null;
		countryName = req.getParameter("cityName");
		country = new Country();
		country.setCountryName(countryName);
		;
		service = new CountryServiceImpl();
		flag = service.saveCountry(country);
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
