<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%UserDTO dto=new UserDTO(); 
List list=(List)request.getAttribute("List");
Iterator it=list.iterator();
String deleteMsg=(String)request.getAttribute("deleteMsg");

%>


<body>
<form action="UserListCtl" method="post">
	<center>
	<%if(deleteMsg!=null){ %>
	<h2><%=deleteMsg %></h2>
	<%} %>
		<h1>User List</h1>
	
		<table border="1" >
		<th></th>
		<tr><input type="text" name="firstName" placeholder="enter first name" value=""></tr>
		<input type="submit" name="operation">
		<br><br>
			<tr>

				<th>Select</th>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>Date Of Birth</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>

			<%while(it.hasNext()){
				dto=(UserDTO)it.next();%>

			<tr>
				<th><input type="checkbox" name="ids" value="<%=dto.getId() %>"></th>
				<td><%=dto.getId()%></td>
				<td><%=dto.getFirstName() %></td>
				<td><%=dto.getLastName() %></td>
				<td><%=dto.getLoginId() %></td>
				<td><%=dto.getPassword() %></td>
				<td><%=dto.getDob() %></td>
				<td><%=dto.getAddress() %></td>
				<td><a href="UserCtl?edit=<%=dto.getId()%>"> edit</a></td>


			</tr>
			<%} %>
		</table>
		<table>
		<th><input type="submit" name="operation" value="delete"></th></table>
		<h3><a href="UserRegistrationCtl">For Registration Click on Link</a></h3>
		<h2><a href="index.jsp"> Main Menu</a></h2>
	</center>

</form>
</body>
</html>