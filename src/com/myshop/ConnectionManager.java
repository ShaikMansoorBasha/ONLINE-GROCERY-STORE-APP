package com.myshop;


import java.sql.*;


public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
	   try
       {
         //  String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=GroceryTest"; 
		  String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ONGSDB"; 		   
          // assuming "DataSource" is your DataSource name
      	 //String connectionUrl  = "jdbc:sqlserver://DESKTOP-05S6KIJ;databaseName=users;";

      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          try
          {            	
             con = DriverManager.getConnection(url,"sa","Shaik@786"); 
              								
          // assuming your SQL Server's	username is "username"               
          // and Price is "Price"
            
          }
             
          
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(Exception e)
      {
         System.out.println(e);
      }

   return con;
}
}

