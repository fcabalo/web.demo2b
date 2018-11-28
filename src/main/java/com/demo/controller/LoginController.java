package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.LoginForm;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		
		final LoginForm loginForm = new LoginForm();
		loginForm.setUsername(username);
		loginForm.setPassword(password);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
		if(dispatcher == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "welcome.jsp doesn't exist.");
		} else {
			request.setAttribute("loginData", loginForm);
			dispatcher.forward(request, response);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
