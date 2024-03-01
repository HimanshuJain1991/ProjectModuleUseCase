<%@page import="in.co.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String msg=(String)request.getAttribute("msg");

%>
<%if(msg!=null) {%>
<h2><%=msg %></h2>
<%} %>
<body>
<h2><a href="index.jsp"> Main Menu</a></h2>
<h2><a href="UserListCtl"> UserList</a></h2>
	<form action="UserRegistrationCtl" method="post">
		<center>
			<table>
			<h1>User Registration</h1>
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName"></td>

				</tr>
				<tr>
					<th>Login Id :</th>
					<td><input type="text" name="loginId"></td>

				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"></td>

				</tr>
				<tr>
					<th>DOB :</th>
					<td><input type="date" name="dob"></td>

				</tr>
				<tr>
					<th>Address :</th>
					<td><input type="text" name="address"></td>

				</tr>
				<tr>
					<th></th>
					<td><button type="submit" name="operation">SignUp</button></td>
				</tr>
				

				</center>
				</form>
</body>
</html>