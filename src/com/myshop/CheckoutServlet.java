package com.myshop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String CurrentSession = request.getSession().getId();
			System.out.println("\nCurrent Session Id: " + CurrentSession);
			// String UserId= request.getParameter("UserId");
			// System.out.print("\nUserID Is:"+UserId);

			/*ProductsListBean prodlistbeanList = new ProductsListBean();
			prodlistbeanList.setCurrentSession(CurrentSession);*/
			// prodlistbeanList.setUserId(request.getParameter("UserId"));
			boolean itemsexist = myshopDAO.Checkout(CurrentSession);
			if (itemsexist) {

				/*
				 * HttpSession session = request.getSession(true);
				 * session.setAttribute("currentSessionUser",prodlistbeanList);
				 * request.getRequestDispatcher("userLogged.jsp").forward(request, response);
				 */
				// response.sendRedirect("userLogged.jsp"); //logged-in page
				response.sendRedirect("Loginpage.jsp");
			}

			else

				response.sendRedirect("Shipping.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
