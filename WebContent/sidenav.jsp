<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.io.*" %>
 <%@ page import = "java.util.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	/* String id = request.getParameter("userid"); */
	/* request.getSession().getId(); */
	/*  String CurrentSession =request.getSession().getId(); */
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ONGSDB";
	//String database = "userone";
	String userid = "sa";
	String password = "Shaik@786";
	try {
		System.out.println("connect to db");
		Class.forName(driver);
		System.out.println("successfully connected to db");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	/* Connection connection1 = null;
	Statement statement1 = null;
	ResultSet resultSet1 = null;
	String username = null; */
	int Itemcount=0;
%>

<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyShop Online Grocery System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/styleone.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="sidebar">
<% 

		String ProdCatsearchQuery = "select '<a href=ProductsListServlet?ProdCat='+ Product_Category_Name+'>'+Product_Category_Name+'</a>' as ProductCategoryurl from Product_Category";

		/* ArrayList<ProductCategoryBean> pcbeanList = new ArrayList<ProductCategoryBean>(); */
		// System.out.println("Query: "+searchQuery);
try {
	Connection connection1 = null;
	Statement statement1 = null;
	ResultSet resultSet1 = null;
							connection1 = DriverManager.getConnection(connectionUrl, userid, password);
							statement1 = connection1.createStatement();
							resultSet1 = statement1.executeQuery(ProdCatsearchQuery);
							
			while (resultSet1.next()) {
				out.println(resultSet1.getString("ProductCategoryurl"));
				
		}
			
}

		catch (Exception ex) {
			System.out.println("Connection DB filed " + ex);
		}
		%>

	<!-- <div class="sidebar">
		<a href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a> <a
			href="ProductsListServlet?ProdCat=Dryfruits">Dryfruits </a> <a
			href="ProductsListServlet?ProdCat=pulses"> pulses</a> <a
			href="ProductsListServlet?ProdCat=Vegetables"> Vegetables</a> <a
			href="ProductsListServlet?ProdCat=Spices"> Spices</a> <a
			href="ProductsListServlet?ProdCat=Fruits"> Fruits</a> <a
			href="ProductsListServlet?ProdCat=Cooking Oil"> Cooking Oil</a> <a
			href="ProductsListServlet?ProdCat=Food Grains"> Food Grains</a> 
			<a href="ProductsListServlet?ProdCat=Indian Rice"> Indian Rice</a> -->
	</div>



</body>
</html>
