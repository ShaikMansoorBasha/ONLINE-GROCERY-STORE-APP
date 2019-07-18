package com.myshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import static java.lang.System.out;

//@WebServlet("/LoginServletone")
public class LoginServletone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServletone() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String User_logged=null;
				try {
			// System.out.println(request.getParameter("un"));
			@SuppressWarnings("unused")
			String CurrentSession = request.getSession().getId();
			System.out.println("\nCurrent Session Id is: " + CurrentSession);
			String username1 = request.getParameter("un");
			System.out.println(username1);
			String password1 = request.getParameter("password");

			UserBean user = new UserBean();

			user.setUserName(username1);
			user.setPassword(password1);

			user = myshopDAO.login(user,CurrentSession);
			if (user.isValid() && user.getUser_logged().equalsIgnoreCase("yes")) {
				myshopDAO.UpdateCartUSer(CurrentSession, user.getUsername());
				HttpSession session = request.getSession(true);
				
				session.setAttribute("currentSessionUser", user);
				request.getRequestDispatcher("Shipping.jsp").forward(request, response);
				// response.sendRedirect("userLogged.jsp"); //logged-in page
			} 
			else if (user.isValid() && !user.getUser_logged().equalsIgnoreCase("yes")) {
				myshopDAO.UpdateCartUSer(CurrentSession, user.getUsername());
                HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				// response.sendRedirect("userLogged.jsp"); //logged-in page
				}
			else {
         request.setAttribute("errorMessage",
						"Invalid username or password If you are not a registered user then please register using the Register button below.");

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Loginpage.jsp");
				rd.forward(request, response);

			}

		}

		catch (Throwable theException) {
			System.out.println(theException);
		}

	}

	
	}


