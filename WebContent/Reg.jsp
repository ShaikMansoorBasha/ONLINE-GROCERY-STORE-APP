<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

/* Add padding to containers */
.containerrg {
	padding: 12px;
	border-radius: 5px;
	background-color: white;
	margin-top: -83px;
	width: 500px;
	margin: auto;
	box-shadow: 0px 0px 8px #52c318;
}

.containerrg h1 {
	text-align: center;
	font-size: 20px;
	border-bottom: 1px solid #eee;
	padding: 10px;
	margin: 10px 0px;
}

.containerrg label {
	width: 30%;
	float: left;
	padding-top:15px;
}
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 70%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 50px;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
</head>
<body>
	<%@include file="Header.jsp"%>
	<%@include file="Header1.jsp"%>
	<%-- <%@include file="sidenav.jsp" %> --%>
	<br>

	<form action="NewUserServlet" method="post">
		<div class="containerrg">
			<h1>Register</h1>


			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>

			<!-- <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" required> -->
			<label for="FirstName"><b>FirstName</b></label> <input type="text"
				placeholder="First Name" name="FirstName"> <label
				for="LastName"><b>LastName</b></label> <input type="text"
				placeholder="Last Name" name="LastName"> 
				<label for="Gender" style="padding-top:0px;"><b>Gender</b></label>Male <input type="radio"
				value="male" name="gender" > Female <input type="radio"
				value="female" name="gender" ><br/><br/>
				 <label
				for="text"><b>PhoneNumber</b></label> <input type="text"
				placeholder=PhoneNumber name="PhoneNumber" required>
			<hr>
			<p>
				By creating an account you agree to our <a href="#">Terms &
					Privacy</a>.
			</p>

			<button type="submit" class="registerbtn">Register</button>
		</div>


	</form>
	<%@include file="Footer.jsp"%>
</body>
</html>
