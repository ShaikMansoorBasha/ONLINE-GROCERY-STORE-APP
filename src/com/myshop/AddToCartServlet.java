package com.myshop;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
     String ProductName= request.getParameter("ProductName");
     System.out.print("Product Name Is:"+ProductName);
     
     String CurrentSession =request.getSession().getId();
     System.out.println("Current Session Id: "+CurrentSession);
     ArrayList<ProductsListBean> prodlistbeanList= new ArrayList<ProductsListBean>();
     prodlistbeanList =myshopDAO.ProductsList(ProductCat);
     
     request.setAttribute("productsList", prodlistbeanList);
        request.getRequestDispatcher("ProductsList.jsp").forward(request, response);
    }*/


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String ProductName= request.getParameter("ProductName");
     System.out.print("Product Name Is:"+ProductName);
     String Quantity= request.getParameter("Quantity");
     System.out.print("Product Quantity Is:"+Quantity); 
     String ProductPrice= request.getParameter("ProductPrice");
     System.out.print("Product ProductPrice  Is:"+ProductPrice);
     //String ProductImageURL= request.getParameter("ProductImageURL");
    // System.out.print("Product_Image_url   Is:"+ProductImageURL);
  
     
     
     String CurrentSession =request.getSession().getId();
     System.out.println("\nCurrent Session Id: "+CurrentSession);
    
  
     
     myshopDAO.AddToCart(ProductName,Quantity,ProductPrice,CurrentSession);

     response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("Product "+ProductName+" added to Cart");
        response.setIntHeader("Refresh", 1);
        
     

    }

}