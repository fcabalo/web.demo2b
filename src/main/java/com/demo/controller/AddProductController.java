package com.demo.controller;

import java.io.IOException;

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

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/add-product")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToyDAO toyDAO;
	private DatabaseConfig databaseConfig;
	
	public void init() throws ServletException {
		this.databaseConfig = new DatabaseConfig();
		this.toyDAO = new ToyDAO(databaseConfig.getUrl(), 
				 databaseConfig.getUsername(), 
				 databaseConfig.getPassword());
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductModel product = toBean(request);
		product.validate();
		
		RequestDispatcher dispatcher = null;
		String viewPage = "/product-catalog?category=t";		
		if(!product.isFormValid()) {
			// login.jsp
			viewPage = "/addToyView.jsp";			
			request.setAttribute("product", product);		
		} else {
			toyDAO.addToy(product);
		}
		
		dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	
	private ProductModel toBean(HttpServletRequest request) {
		ProductModel product = new ProductModel();
		
		product.setId(request.getParameter("id"));
		product.setName(request.getParameter("name"));
		product.setDesc(request.getParameter("desc"));
		product.setsPrice(request.getParameter("price"));
		
		return product;
	}

}
