package com.myshop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/index.jsp")
public class ProductsListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ProductsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /*  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {            
    	request.setAttribute("result", "This is the result of the servlet call");
    	request.getRequestDispatcher("result.jsp").forward(request, response);
   // 	request.setAttribute("message", "hello");
}*/
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	
    	String ProductCat= request.getParameter("ProdCat");
    	System.out.print("Product Category is:"+ProductCat);
    	String CurrentSession =request.getSession().getId();
        System.out.println("Current Session Id: "+CurrentSession);
    	ArrayList<ProductsListBean> prodlistbeanList= new ArrayList<ProductsListBean>();
    	prodlistbeanList =myshopDAO.ProductsList(ProductCat);
    	
    	request.setAttribute("productsList", prodlistbeanList);
        request.getRequestDispatcher("ProductsList.jsp").forward(request, response);
    }


    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
*/
}
