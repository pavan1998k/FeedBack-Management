<%@page import="com.ty.feedback.dto.Courses"%>
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
			List<Courses> list=(List<Courses>)request.getAttribute("viewCourse");
		%>
		<table cellpadding="2" border="3">
			<tr>
				<th>Id</th>
				<th>Course Name</th>
				<th>Duration</th>
				<th>Fees</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<% for(Courses courses: list){ %>
			<tr>
				<th><%=courses.getId() %></th>
				<th><%=courses.getCourseName()%></th>
				<th><%=courses.getDuration()%></th>
				<th><%=courses.getFees()%></th>
				<th><a href="edit?id=<%=courses.getId()%>">Edit</a></th>
			<th><a href="delete?id=<%=courses.getId()%>">Delete</a></th>
			</tr>
			<%} %>
		</table>
</body>
</html>