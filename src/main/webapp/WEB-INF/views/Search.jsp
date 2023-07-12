<%@page import="com.jspiders.customerdetails.Repository.Pojo.CustomerPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <%String msg=(String)request.getAttribute("msg"); %>
    <%CustomerPojo pojo=(CustomerPojo)request.getAttribute("data"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">
body {
background-image: linear-gradient(pink,red);
height: 570px;

background-repeat: no-repeat;
background-size: cover;
	
}
#search{
height: 30px;
width: 70px;
border-radius: 5px;
color: red;
}
form{
margin-top: 40px;
}

from table{
margin: auto;
width:100%;
}
tr{
text-align: center;
}
fieldset table{
margin: auto;
text-align: left;
	
}
td{
color: black;
width: 100%;

padding: (self-spacing-unit*1.5) 0;

}
fieldset {
	margin: 15px 520px;
	text-align: center;
	border: 1px solid black;
}
legend {
	color: white;
	background-color: #333;

}

#data{
background-color: white;
border: 1px solid black;
color:black;
width:500px;
margin-top: 15px;

}
#data td{
border: 1px solid black;
text-align: center;
width:500px;

}

</style>
</head>
<body>
<div align="center">
<form action="./search" method="post">
<fieldset>
<legend>:::Search Customer:::</legend>
<table>
<tr>
<td>Enter ID</td>
<td> <input type="text" name="id" /> </td>
</tr>

</table>

</fieldset>
<input type="submit" value="Search" id="search">

</form>
<%
if(msg!=null){
%>
<h3><%=msg %></h3>
<%} %>
<%if(pojo!=null){ %>
<table id="data">
<thead>
<tr>
<td>ID</td>
<td>Name</td>
<td>Email</td>
<td>Contact</td>
<td>Address</td>
</tr>
</thead>
<tr>
<td><%=pojo.getId() %></td>
<td><%=pojo.getName() %></td>
<td><%=pojo.getEmail() %></td>
<td><%=pojo.getContact() %></td>
<td><%=pojo.getAddress() %></td>
</tr>
</table>
<%} %>
</div>
</body>
</html>