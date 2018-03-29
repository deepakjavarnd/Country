package com.javarnd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.domain.Sports;
import com.javarnd.service.SportsService;
import com.javarnd.service.SportsServiceImpl;

public class SportsSaveController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sportsName = null;
		Sports sports = null;
		boolean flag = false;
		SportsService service = null;
		sportsName = req.getParameter("sportsName");
		sports = new Sports();
		sports.setSportsName(sportsName);
		System.out.println(sportsName);
		service = new SportsServiceImpl();
		flag = service.saveSports(sports);
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
