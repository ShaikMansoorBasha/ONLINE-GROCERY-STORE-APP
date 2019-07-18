package com.myshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ProductSaveServlet")
public class ProductSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductSaveServlet() {
		super();

	}

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Product_Name=request.getParameter("productname");
		 System.out.print("/Product Name Is:"+Product_Name);
		String Manufacturer=request.getParameter("manufacturer");
		 System.out.print("/ManufacturerIs:"+Manufacturer);
		String Product_Image_url=request.getParameter("productimageurl");
		 System.out.print("/Product_Image_url Is:"+Product_Image_url);
		String Product_Category_ID=request.getParameter("productcategoryid");
		 System.out.print("/Product_Category_ID Name Is:"+Product_Category_ID);
		String Product_price=request.getParameter("productprice");
		 System.out.print("/Product_price Name Is:"+Product_price);
		//Emp e=new Emp();
		ProductsListBean prodlistbeanList= new ProductsListBean();
		prodlistbeanList.setProductName(Product_Name);
		
		prodlistbeanList.setManufacturer(Manufacturer);
		prodlistbeanList.setProductImageURL(Product_Image_url);
		prodlistbeanList.setProduct_Category_ID(Product_Category_ID);
		prodlistbeanList.setProductPrice(Product_price);
		int status=myshopDAO.save(prodlistbeanList);
		if(status>0){
		/*	out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("AddNewProduct.jsp").include(request, response);*/
			request.setAttribute("Success",
					"Product Added Successfully");

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddNewProduct.jsp");
			rd.forward(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		out.close();
	}
}
