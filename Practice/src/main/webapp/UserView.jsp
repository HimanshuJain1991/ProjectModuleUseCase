<%@page import="in.co.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="dto1" class="in.co.rays.dto.UserDTO"
		scope="request"></jsp:useBean>
<body>
<%
UserDTO dto=(UserDTO)request.getAttribute("userData");

%>
<form action="UserCtl" method="post">
<h2><a href="UserRegistrationCtl">Registration</a></h2>
<h2><a href="UserListCtl"> UserList</a></h2>
		<center>
		<%String updateMsg=(String)request.getAttribute("updateMsg");
		if(updateMsg!=null){
		%>
		<h2><%=updateMsg %></h2>
	
		<%} %>
			<table>
		
			<h1>User View</h1>
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName" value="<%=dto.getFirstName() %>"></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName" value="<%=dto.getLastName()%>"></td>

				</tr>
				<tr>
					<th>Login Id :</th>
					<td><input type="text" name="loginId" value="<%=dto.getLoginId()%>"></td>

				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="text" name="password" value="<%=dto.getPassword()%>"  ></td>

				</tr>
				<%-- <tr>
					<th>DOB :</th>
					<td><input type="date" name="dob" value="<%=dto.getDob()%>"></td>

				</tr> --%>
				<tr>
					<th>Address :</th>
					<td><input type="text" name="address" value="<%=dto.getAddress()%>"></td>

				</tr>
				<tr>
					<th></th>
					<td><button type="submit" name="operation">Update</button></td>
				</tr>
			
				<input type="hidden" name="id" value="<%=dto.getId()%>">


				</center>
				</form>
				
</body>
</html>