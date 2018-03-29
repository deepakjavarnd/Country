package com.javarnd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.service.UserLoginService;
import com.javarnd.service.UserLoginServiceImpl;

public class UserLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = null;
		String password = null;
		UserLoginService service = null;
		boolean flag = false;

		userName = req.getParameter("userName");
		password = req.getParameter("password");
		service = new UserLoginServiceImpl();
		flag = service.isAuthenticated(userName, password);
		if (flag) {
			res.sendRedirect("home.jsp");
		} else {
			res.sendRedirect("login_failed.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
