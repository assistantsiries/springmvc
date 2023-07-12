<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product management</title>
<style type="text/css">
form{
margin-top:40px;
}
from table{
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
	text-align: left;
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
#admin{
height: 30px;
width: 120px;
border-radius: 5px;
color: red;

}

</style>
</head>
<body>
<div align="center">
<form action="./create" method="post">
<fieldset>
<legend>:::Create Admin:::</legend>

<table>
<tr>
<td>Enter Username</td>
<td> <input type="text" name="username"> </td>
</tr>
<tr>
<td>Enter Password</td>
<td> <input type="password" name="password"></td>
</tr>
</table>
</fieldset>
<input type="submit" value="Create Account" id="admin">
</form>



</div>
</body>
</html>