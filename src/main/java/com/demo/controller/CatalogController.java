package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.BookDAO;
import com.demo.dao.FlowerDAO;
import com.demo.dao.ToyDAO;
import com.demo.model.ProductModel;
import com.demo.util.DatabaseConfig;

@WebServlet(urlPatterns = "/product-catalog", loadOnStartup = 1)
public class CatalogController extends HttpServlet {
	private BookDAO bookDAO;
	private FlowerDAO flowerDAO;
	private ToyDAO toyDAO;
	private DatabaseConfig databaseConfig;

	@Override
	public void init() throws ServletException {
		this.databaseConfig = new DatabaseConfig();
		this.bookDAO = new BookDAO(databaseConfig.getUrl(), 
													 databaseConfig.getUsername(), 
													 databaseConfig.getPassword());
		this.flowerDAO = new FlowerDAO(databaseConfig.getUrl(), 
				 databaseConfig.getUsername(), 
				 databaseConfig.getPassword());
		this.toyDAO = new ToyDAO(databaseConfig.getUrl(), 
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
		String category = request.getParameter("category");
		if(category == null) {
			category = "";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogView.jsp");
		List<ProductModel> products = new ArrayList<>();
		switch(category) {
		case "b":
			products = bookDAO.findAll();
			break;
		case "f":
			products = flowerDAO.findAll();
			break;
		case "t":
			products = toyDAO.findAll();
			break;
		default:
			break;
		} 
		request.setAttribute("products", products);
		request.setAttribute("category", category);
		dispatcher.forward(request, response);
	}
}
