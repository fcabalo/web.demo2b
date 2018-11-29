package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.ItemModel;
import com.demo.model.ShoppingCartModel;

@WebServlet(urlPatterns = "/shopping-cart", loadOnStartup = 1)
public class ShoppingCartController extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        final HttpSession session = request.getSession(true);
        ShoppingCartModel shoppingCart = (ShoppingCartModel)session.getAttribute("shoppingCart");
        List<ItemModel> items = new ArrayList<>();
        if (shoppingCart == null) {
        	shoppingCart = new ShoppingCartModel(items, 0, 0);
        }
        
        String action = request.getParameter("action");
        if(action == null) {
        	action = "";
        }
        if(action.equals("add")) {
	        final String pid = request.getParameter("pid");
	        final String name = request.getParameter("name");
	        final String desc = request.getParameter("desc");
	        final String price = request.getParameter("price");
	        final String quantity = request.getParameter("quantity");
	        final int iPrice = Integer.parseInt(price);
	        final int iQuantity = Integer.parseInt(quantity);
	        
	        ItemModel addedItem = new ItemModel(pid, name, desc, iPrice, iQuantity, iPrice*iQuantity);
	        shoppingCart.addItem(addedItem);
        } else if(action.equals("remove")){
        	final String pid = request.getParameter("pid");
        	final String quantity = request.getParameter("quantity");
        	final int iQuantity = Integer.parseInt(quantity);
        	
        	shoppingCart.removeItem(pid, iQuantity);
        } 

        session.setAttribute("shoppingCart", shoppingCart);

        RequestDispatcher dispatcher = null;
        if(shoppingCart.getItems().size() <= 0)
        {
        	dispatcher = request.getRequestDispatcher("/catalogView.jsp");	
        } else {
        	dispatcher = request.getRequestDispatcher("/cartView.jsp");
        }
        dispatcher.forward(request, response);
    }
}
