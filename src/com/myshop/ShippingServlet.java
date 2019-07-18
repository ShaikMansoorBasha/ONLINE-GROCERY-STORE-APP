package com.myshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/ShippingServlet")
public class ShippingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShippingServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("FullName");
		System.out.println("your name is "+name);
	/*	String password=request.getParameter("password");*/
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		UserBean user = new UserBean();
		user.setFullName(name);
		System.out.println("your name is "+name);
		/*user.setPassword(password);*/
		user.setEmail(email);
		user.setAddress(address);
		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		int status=myshopDAO.save(user);
		if(status>0){
			
			request.getRequestDispatcher("Thanks.jsp").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		out.close();
	}

}
