package com.myshop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/index.jsp")
public class ProductsCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ProductsCategoryServlet() {
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
    /*    List<String> products = new ArrayList<String>();
        products.add("Car");
        products.add("Gun");
        products.add("Shades");
*/   
    	String CurrentSession =request.getSession().getId();
        System.out.println("Current Session Id: "+CurrentSession);
    	
    	ArrayList<ProductCategoryBean> pcbeanList= new ArrayList<ProductCategoryBean>();
    	pcbeanList =myshopDAO.Productcategry();
    	
    	request.setAttribute("productsCatList", pcbeanList);
        request.getRequestDispatcher("ProdCat.jsp").forward(request, response);
    }


    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
*/
}
