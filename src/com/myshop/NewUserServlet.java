package com.myshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewUserServlet() {
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
		String email=request.getParameter("email");
		System.out.println("your email is:"+email);
		String password=request.getParameter("password");
		String FirstName=request.getParameter("FirstName");
		String LastName=request.getParameter("LastName");
		String Gender=request.getParameter("gender");
		String PhoneNumber=request.getParameter("PhoneNumber");
		String CurrentSession = request.getSession().getId();
		System.out.println("\nCurrent Session Id: " + CurrentSession);
	//	Emp e=new Emp();
		 //myshopDAO.DeleteCart(ProductName);
		UserBean user = new UserBean();
		
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(FirstName);
		user.setLastName(LastName);
		user.setGender(Gender);
		user.setPhoneNumber(PhoneNumber);
		user.setCurrentSession(CurrentSession);
		int status=myshopDAO.NewUser(user);
		if(status>0){
			
			request.setAttribute("Success",
					"Thank You,For Sign Up");
			
	    /*    request.getRequestDispatcher("ProductsList.jsp").forward(request, response);*/
	    
			response.sendRedirect("index.jsp");
			/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);*/
		}
		else{
			out.println("Sorry! unable to save record");
		}
		out.close();
	}

}
