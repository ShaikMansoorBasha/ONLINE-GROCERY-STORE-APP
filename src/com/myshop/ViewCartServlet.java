package com.myshop;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String CurrentSession = request.getSession().getId();
		System.out.print("CurrentSession is:" + CurrentSession);

		ArrayList<ProductsListBean> prodlistbeanList = new ArrayList<ProductsListBean>();
		prodlistbeanList = myshopDAO.ViewCart(CurrentSession);

		request.setAttribute("CartDeatils", prodlistbeanList);
		request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
