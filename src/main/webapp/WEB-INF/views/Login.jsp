<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer details</title>
<style type="text/css">
form {
	margin-top: 40px;
}
form  table{
	margin: auto;
	width: 100%;
}
tr{
text-align: center;
}
fieldset table {
	margin: auto;
	text-align: left;
}
fieldset {
	margin: 15px 520px;
	text-align:center; 
	border: 1px solid black;
}
legend {
	color: white;
	background-color: #333;
}
body {
background-image: linear-gradient(pink,red);
height: 570px;

background-repeat: no-repeat;
background-size: cover;
}
#login{

height: 30px;
width: 70px;
border-radius: 5px;
color: red;
}

</style>
</head>
<body>
<div align="center">
<a href="./create"> Create Account</a>
<form action="./login" method="post">
<fieldset>
<legend>:::Login:::</legend>
<table>
<tr>
<td>Username</td>
<td> <input type="text" name="username"> </td>
</tr>
<tr>
<td>Password</td>
<td> <input type="password" name="password"> </td>
</tr>

</table>
</fieldset>
<input type="submit" value="Login" id="login">
</form>
<%if(msg!=null){ %>
<h3>  <%=msg %> </h3>
<%} %>
</div>
</body>
</html>