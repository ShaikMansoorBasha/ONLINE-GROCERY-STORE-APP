package com.myshop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/OrderHistroySevelet1")
public class OrderHistroySevelet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public OrderHistroySevelet1() {
        super();
       }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	/*	String CurrentSession = request.getSession().getId();
		System.out.println("\nCurrent Session Id is: " + CurrentSession);
		String username1 = request.getParameter("un");
		System.out.println(username1);
		

		UserBean user = new UserBean();

		user.setUserName(username1);
	
		user = myshopDAO.orderhistroy(username1);*/
		
	/*	response.getWriter().append("orderhistroy.jsp").append(request.getContextPath());*/
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/orderhistroy.jsp");
		rd.forward(request, response);
	}



}
