package com.myshop;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/index.jsp")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ProductName = request.getParameter("ProductName");
		System.out.print("Product Name is:" + ProductName);
		String CurrentSession = request.getSession().getId();
		System.out.println("Current Session Id: " + CurrentSession);
		ArrayList<ProductsListBean> prodlistbeanList = new ArrayList<ProductsListBean>();
		prodlistbeanList = myshopDAO.ProductDetails(ProductName);

		request.setAttribute("ProductDetails", prodlistbeanList);
		request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);
	}

}
