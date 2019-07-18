package com.myshop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteProductServlet
 */
//@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteProductServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ProductName = request.getParameter("ProductName");
		System.out.print("Product Name is:" + ProductName);
		String CurrentSession = request.getSession().getId();
		System.out.println("Current Session Id: " + CurrentSession);

	
		 myshopDAO.DeleteCart(ProductName);
		/* response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write("Product "+ProductName+" Deleted From Cart");*/
		// request.setAttribute("CartDeatils", prodlistbeanList);
			//request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
		 response.sendRedirect("ViewCartServlet");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	

}
