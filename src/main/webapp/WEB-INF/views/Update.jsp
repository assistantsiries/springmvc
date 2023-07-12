<%@ page import="com.jspiders.customerdetails.Repository.Pojo.CustomerPojo" %>
<%@  page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="NavBar.jsp"></jsp:include> 
<% String msg=(String)request.getAttribute("msg");
  CustomerPojo customer=(CustomerPojo)request.getAttribute("cust");
  List<CustomerPojo> customers=(List<CustomerPojo>)request.getAttribute("list");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update page</title>
<style type="text/css">
body {
background-image: linear-gradient(pink,red);
height: 570px;

background-repeat: no-repeat;
background-size: cover;
	
}
form{
margin-top: 40px;
}
form table{
margin: auto;
width: 100%;
}
tr{
text-align: center;
}
fieldset table{
	margin: auto;
	text-align: left;
}
thead{
color:white;
width: 100%;
background:#000;
padding: ($half-spacing-unit* 1.5) 0;
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
width: 100%;
border: 1px solid black;
margin-top:15px;
}
#data td{
border: 1px solid black;
text-align: center;
}
.upd{
height: 30px;
width: 70px;
border-radius: 5px;
color: red;
}
</style>
</head>
<body>
<div align="center">
<%if(customer !=null){ %>
<form action="./updateData" method="post">
<fieldset>
<legend>::: Update Customer :::</legend>
<table>
<tr hidden="true">
<td>ID</td>
<td><input type="text" name="id" value="<%=customer.getId()%> "></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" value="<%=customer.getName() %>"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="email" value="<%=customer.getEmail() %>"></td>
</tr>
<tr>
<td>Contact</td>
<td><input type="text" name="contact" value="<%=customer.getContact() %>"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="address" value="<%=customer.getAddress() %>"></td>
</tr>
</table>
</fieldset>
<input type="submit" value="Update" class="upd">
</form>
<%} else {%>
<form action="./update" method="post">
<fieldset>
<legend>:::Select Customer:::</legend>
<table>
<tr>
<td>Enter Id</td>
<td><input type="text" name="id"></td>
</tr>
</table>
</fieldset>
<input type="submit" value="Select" class="upd">
</form>
<%if(msg!=null){ %>
<h3><%= msg %></h3>
<%} %>
<%if(customers!=null){ %>
<table id="data">
<thead>
<tr>
<td>Id</td>
<td>Name</td>
<td>Email</td>
<td>Contact</td>
<td>Address</td>
</tr>
</thead>
<%for(CustomerPojo pojo : customers) {%>
<tr>
<td><%=pojo.getId() %></td>
<td><%=pojo.getName() %></td>
<td><%=pojo.getEmail() %></td>
<td><%=pojo.getContact() %></td>
<td><%=pojo.getAddress() %></td>
</tr>
<%} %>
</table>
<% } %>
<% } %>
</div>
</body>
</html>