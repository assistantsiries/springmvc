<%@page import="com.jspiders.customerdetails.Repository.Pojo.CustomerPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <jsp:include page="NavBar.jsp"></jsp:include>
    <%String msg=(String)request.getAttribute("msg"); %>
   <%List<CustomerPojo> customers=(List<CustomerPojo>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove page</title>
<style type="text/css">
body {
background-image: linear-gradient(pink,red);
height: 570px;

background-repeat: no-repeat;
background-size: cover;
	
}
#remove {
height: 30px;
width: 70px;
border-radius: 5px;
color: red;
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
fieldset table {
	margin: auto;
	text-align: center;
}
thead{
color:white;
width:100%;
background: #000;
width: 100%;
}
fieldset{
margin: 15px 520px;
text-align: center;
border: 1px solid black;
}
legend {
	color: white;
	background-color: #333;
}
body{
}
#data{
padding: 2px;
border: 1px solid black;
margin-top: 20px;
background-color: white;

}
#data td {
text-align: center;
border: 1px solid black;
width: 200px;
}
#data tr{
text-align: center;
border: 1px solid black;
}

</style>
</head>
<body>
<div align="center">
<form action="./remove" method="post">
<fieldset>
<legend>:::Remove Customer:::</legend>
<table>
<tr>
<td>Enter ID </td>
<td><input type="text" name="id"> </td>
</tr>

</table>

</fieldset>
<input type="submit" value="Remove" id="remove"> 
</form>
<%if(msg!=null){ %>
<h3> <%=msg %> </h3>
<%} %>
<%if(customers !=null ){ %>
<table id="data">
<thead>
<tr> 
<td>ID</td>
<td>NAME</td>
<td>EMAIL</td>
<td>CONTACT</td>
<td>ADDESS</td>
</tr>
</thead>
<%for(CustomerPojo pojo: customers){ %>
<tr>
<td> <%=pojo.getId() %> </td>
<td> <%=pojo.getName() %> </td>
<td> <%=pojo.getEmail() %> </td>
<td> <%=pojo.getContact() %>  </td>
<td> <%=pojo.getAddress() %> </td>


</tr>
<%} %>
</table>
<%}
%>
</div>
</body>
</html>