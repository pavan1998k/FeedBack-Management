<%@page import="com.ty.feedback.dto.TrainingPrograms"%>
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
		List<TrainingPrograms> list=(List<TrainingPrograms>)request.getAttribute("viewProgram");
	%>
	<table cellpadding="2" border="3">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Starting Date</th>
			<th>Ending Date</th>
			<th>Faculty Name</th>
			<th>Edit</th>
			<th>Delete</th>
			<th>FeedBack</th>
		</tr>
		
		<%
			for(TrainingPrograms tPrograms: list){
		%>
		<tr>
			<th><%=tPrograms.getId()%></th>
			<th><%=tPrograms.getName()%></th>
			<th><%=tPrograms.getStartingDate()%></th>
			<th><%=tPrograms.getEndingdate()%></th>
			<th><%=tPrograms.getFacultyName()%></th>
			<th><a href="edit?id=<%=tPrograms.getId()%>">Edit</a></th>
			<th><a href="delete?id=<%=tPrograms.getId()%>">Delete</a></th>
			<th><a href="CreateFeedBack.jsp?id=<%=tPrograms.getId()%>">clickHere</a></th>
		</tr>
		<%} %>
	</table>
	
</body>
</html>