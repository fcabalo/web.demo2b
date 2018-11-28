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
	        String pid = request.getParameter("pid");
	        String name = request.getParameter("name");
	        String desc = request.getParameter("desc");
	        String price = request.getParameter("price");
	        int iPrice = Integer.parseInt(price);
	        
	        ItemModel addedItem = new ItemModel(pid, name, desc, iPrice, 1, iPrice);
	        shoppingCart.addItem(addedItem);
        } else if(action.equals("remove")){
        	String pid = request.getParameter("pid");
        	shoppingCart.removeItem(pid);
        } 

        session.setAttribute("shoppingCart", shoppingCart);

        final RequestDispatcher dispatcher = request.getRequestDispatcher("/cartView.jsp");
        dispatcher.forward(request, response);
    }
}
