package com.demo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.ShoppingCartModel;

/**
 * Servlet Filter implementation class ShoppingCartFilter
 */
public class ShoppingCartFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ShoppingCartFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession httpSession = (HttpSession)httpRequest.getSession();
		if(httpSession.getAttribute("shoppingCart") == null) {
			httpResponse.sendRedirect("./");
		} else {
			ShoppingCartModel shoppingCart = (ShoppingCartModel)httpSession.getAttribute("shoppingCart");
			if(shoppingCart.getItems() == null || shoppingCart.getItems().size() <= 0) {
				httpResponse.sendRedirect("./");
			} else {
				chain.doFilter(request, response);
			}
		} 
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
