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
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String username = null;
	int Itemcount=0;
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta charset="ISO-8859-1">
<title>::ONLINE GROCERY STORE</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/styleone.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- <a href="login.html"></a> -->
	<div id="wrapper">
		<div id="header">
			<div id="subheader">
				<div class="container">
					<p>
						<marquee>One Shop For All Your Grocery Needs</marquee>
					</p>
				</div>
			</div>
			<!-- ==main header== -->
			<div id="main-header">
				<!-- logo -->
				<div id="logo">
					<a href="http://localhost:8080/ongs/index.jsp"
						style="text-decoration: none"> <span id="ist">MY</span><span
						id="iist">Shop.com</span>
					</a>
				</div>
				<!-- ==search area== -->
				<div class="search">
					<form class="search-form" action="SearchServlet">
						<input type="text" name="searchstring" placeholder="Search..." />
						<input type="submit" value="Submit">
					</form>
				</div>
				<%
						try {
							connection = DriverManager.getConnection(connectionUrl, userid, password);
							statement = connection.createStatement();
							String CurrentSession = request.getSession().getId();
							System.out.println(CurrentSession);
		    /*  String qury = "select distinct (username) from Cart join ongs on ongs.User_ID=Cart.User_ID WHERE CurrentSession ='7A37284FF9C13FCCE3B1FCC12B20F280'";					
             String qury = "select distinct (username) from Cart join ongs on ongs.User_ID=Cart.User_ID WHERE cart.CurrentSession ='"+CurrentSession+"';";   */
 					
						  String qury1 =" select count(Quantity) as itemscount from Cart where  CurrentSession='"+CurrentSession+"';"; 
							System.out.println(qury1);
                            	resultSet = statement.executeQuery(qury1);
							    System.out.println(resultSet);
							    if (resultSet.next()) {
							    	Itemcount= resultSet.getInt("itemscount");
							
								System.out.println( "your name is:" +Itemcount);

							    }
					%>
					
					<%
						connection.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					%>
				<div class="cart">
				<div class="badge">
				<a href="ViewCartServlet" input type='hidden' id='CurrentSession' name='CurrentSession'>
				<img src="images/cartbutton.png"/> </a>
				<span>
				<%= Itemcount%> Items   </span>
				<!-- <a href="ViewCartServlet" input type='hidden' id='CurrentSession' name='CurrentSession'>
				<img src="images/cartbutton.png"/> </a> -->
				</div>
<div class="order">

					<%
						try {
							connection = DriverManager.getConnection(connectionUrl, userid, password);
							statement = connection.createStatement();
							String CurrentSession = request.getSession().getId();
							System.out.println(CurrentSession);
		    /*  String qury = "select distinct (username) from Cart join ongs on ongs.User_ID=Cart.User_ID WHERE CurrentSession ='7A37284FF9C13FCCE3B1FCC12B20F280'";					
             String qury = "select distinct (username) from Cart join ongs on ongs.User_ID=Cart.User_ID WHERE cart.CurrentSession ='"+CurrentSession+"';";   */
 					
						  String qury ="select distinct (User_logged),username from ongs WHERE CurrentSession ='"+CurrentSession+"';"; 
							System.out.println(qury);
                            	resultSet = statement.executeQuery(qury);
							    System.out.println(resultSet);
							    if (resultSet.next()) {
								username = resultSet.getString("username");
							
								System.out.println( "your name is:" +username);

								out.println("welcome " + username);
								out.println("<a href='Logout.jsp'>Log out</a>");
								 /* out.println("<a href='orderhistory.jsp'> <option value='Order Histroy'>Order Histroy</option></a> ");  */
								
								
							} else {
								out.println(" <a href='Loginpage.jsp'>Login</a>");
							}
					%>
					</div>
					<%
						connection.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					%>
					<!-- <a href="Loginpage.jsp">Login</a> -->

				</div>
			</div>
		</div>
</body>
</html>