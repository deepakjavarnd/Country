package com.javarnd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.domain.Country;
import com.javarnd.service.CountryService;
import com.javarnd.service.CountryServiceImpl;

public class GetCountryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Country> country = null;
		CountryService service = null;

		service = new CountryServiceImpl();
		country = service.getCountryInformation();
		if (country != null) {
			req.setAttribute("Country", country);
			req.getRequestDispatcher("show_country_information.jsp").forward(req, res);
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
