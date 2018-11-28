package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.AccountHolderDAO;
import com.demo.model.AccountHolder;
import com.demo.util.DatabaseConfig;

@WebServlet(urlPatterns = "/account-holders", loadOnStartup = 1)
public class AccountHolderController extends HttpServlet {
	private AccountHolderDAO accountHolderDAO;
	private DatabaseConfig databaseConfig;

	@Override
	public void init() throws ServletException {
		this.databaseConfig = new DatabaseConfig();
		this.accountHolderDAO = new AccountHolderDAO(databaseConfig.getUrl(), 
													 databaseConfig.getUsername(), 
													 databaseConfig.getPassword());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/accountHoldersView.jsp");
		List<AccountHolder> accountHolders = accountHolderDAO.findAll();
		request.setAttribute("accountHolders", accountHolders);
		dispatcher.forward(request, response);
	}
}
