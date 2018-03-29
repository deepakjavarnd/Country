package com.javarnd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.domain.City;
import com.javarnd.service.CityService;
import com.javarnd.service.CityServiceImpl;

public class CitySaveController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cityName = null;
		City city = null;
		boolean flag = false;
		CityService service = null;
		cityName = req.getParameter("cityName");
		city = new City();
		city.setCityName(cityName);
		System.out.println(cityName);
		service = new CityServiceImpl();
		flag = service.saveCity(city);
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
