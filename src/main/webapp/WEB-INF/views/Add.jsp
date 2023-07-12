<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <% String msg=(String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
</title>
<style type="text/css">
body{

background-image: linear-gradient(pink,red);
height: 570px;

background-repeat: no-repeat;
background-size: cover;

}
form{
margin-top: 40px;


}
#add{
height: 30px;
width: 70px;
border-radius: 5px;
color: red;
}
fieldset {
	border: 1px solid black;
	margin: 15px 520px;
	text-align: center;
}
tr{
padding: 2px;
}

</style>
</head>
<body>
<div align="center" id="main">
<form action="./add" method="post">
<fieldset>
<legend>:::Add Customers:::</legend>
<table>
<tr>
<td>Name</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="email"/></td>
</tr>
<tr>
<td>Contact</td>
<td><input type="text" name="contact"/></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="address"/></td>
</tr>

</table>
</fieldset>
<input type="submit" value="Add" id="add"/>
<%if(msg!=null){ 
%>
<h3><%=msg%></h3>

<%} %>

</form>

</div>
</body>
</html>