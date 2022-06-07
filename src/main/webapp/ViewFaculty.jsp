<%@page import="com.ty.feedback.service.FacultiesService"%>
<%@page import="com.ty.feedback.dto.Faculties"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		List<Faculties> list=(List<Faculties>)request.getAttribute("viewFaculty");
		%>
		<table cellpadding=10 border="2">
			<tr>
				<th>Id: </th>
				<th>Name: </th>
				<th>Email: </th>
				<th>Phone: </th>
				<th>Salary: </th>
				<th>skill: </th>
				<th>Edit: </th>
				<th>Delete: </th>
			</tr>
			<% for(Faculties faculties:list) {%>
			<tr>
				
				<th><%=faculties.getId()%></th>
				<th><%=faculties.getName()%></th>
				<th><%=faculties.getEmail()%></th>
				<th><%=faculties.getPhone()%></th>
				<th><%=faculties.getSalary()%></th>
				<th><%=faculties.getSkills()%></th>
				<th><a href="editFaculty?id=<%=faculties.getId()%>">Edit</a></th>
			<th><a href="delete?id=<%=faculties.getId()%>">Delete</a></th>
			</tr>
			<%} %>
		</table>
</body>
</html>