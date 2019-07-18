package com.myshop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
			

		@SuppressWarnings("unused")
		String ProductName = request.getParameter("searchstring");

		System.out.println(ProductName);
		String CurrentSession =request.getSession().getId();
        System.out.println("Current Session Id: "+CurrentSession);
		

		ArrayList<ProductsListBean> prodlistbeanList = new ArrayList<ProductsListBean>();
		
		

		prodlistbeanList = myshopDAO.Search(ProductName);

		request.setAttribute("productsList", prodlistbeanList);
        request.getRequestDispatcher("ProductsList.jsp").forward(request, response);

	}
}
