<%@page import="java.util.List"%>
<%@page import="com.ty.feedback.dto.CoOrdinate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			List<CoOrdinate> list = (List<CoOrdinate>)request.getAttribute("view");
		%>
		<table border="3" cellpadding=10>
			<tr>
				<th>Id</th>
				<th>CoOrdinate Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Phone</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
				
		<%
		for (CoOrdinate coOrdinate : list) {
		%>
			<tr>
				<th><%=coOrdinate.getId()%></th>
				<th><%=coOrdinate.getName()%></th>
				<th><%=coOrdinate.getEmail()%></th>
				<th><%=coOrdinate.getPassword()%></th>
				<th><%=coOrdinate.getPhone()%></th>
				<th> <a href="edit?id=<%=coOrdinate.getId()%>">Edit</a> </th>
				<th> <a href="delete?id=<%=coOrdinate.getId()%>">Delete</a> </th>
			</tr>
		<%
		}
		%>
		
		</table>
</body>
</html>