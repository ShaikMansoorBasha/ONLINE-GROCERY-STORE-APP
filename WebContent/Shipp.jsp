<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.myshop.UserBean" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyShop Online Grocery System</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<!-- <link href="css/style.css" rel="stylesheet" type="text/css"> -->
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/myshopjs.js" type="text/javascript"></script>
</head>

<style>
/* body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
} */

* {
  box-sizing: border-box;
}

.rowsh {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: -22px -16px;
 
}
.containerlog {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 945px;
  width:100%;
  
}
.containerlog p{
width:100%;
margin:1px 1px 1px 1px;
padding:1px 1px 1px 1px;
height:10px;

}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.containersh {
 /*  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px; */
  background-color: #f2f2f2;
    padding: 12px;
    border: 1px solid lightgrey;
    border-radius: 3px;
    width: 500px;
    margin: auto;
    border-radius: 5px;
    box-shadow: 0px 0px 4px #52c318;
}
}
.containersh h1{
text-align: center;
font-size: 20px;
border-bottom: 1px solid #eee;
padding: 10px;
margin: 10px 0px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 14px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-containersh {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 36px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .rowsh {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
</head>
<body>

<%@include file="Header.jsp"%>
	<%@include file="Header1.jsp"%>
	<%-- <jsp:include page ="sidenav.jsp"/> --%>
	<%-- <div class="containerlog">
	
		<p><center>
		            <% UserBean currentUser = ((UserBean) (session.getAttribute("currentSessionUser")));%> 
   Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
   <a href="Logout.jsp">Logout</a> </center> </p>
 
		
	</div> --%>
<div class="rowsh">
  
    <div class="containersh">
      <div style="color:red" margin-left="300px"><p><center>${user}</center></p></div> 
      
     <!--  <form action="Thanks.jsp"> -->
      <%--   <div style="color:red" margin-left="300px"><p><center>${Success}</center></p></div>    --%>
      
        <div class="rowsh">
          <div class="col-50">
            <h1>Billing Address</h1>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input type="text" id="fname" name="FullName" placeholder="John M. Doe">
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" placeholder="john@example.com">
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="New York">

            <div class="rowsh">
              <div class="col-50">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="NY">
              </div>
              <div class="col-50">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="10001">
              </div>
            </div>
          </div>

        
          
        </div>
       <!--  <label>
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        </label> -->
        <a href="ShippingServlet">
        <input type="submit" value="Continue to checkout" class="btn"></a>
      </form>
    </div>
  </div>
  
  
<%@include file="Footer.jsp"%>
</body>
</html>
