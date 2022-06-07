<%@page import="com.ty.feedback.dto.FeedBack"%>
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
		<% List<FeedBack> lFeedBacks=(List<FeedBack>)request.getAttribute("viewFeedBack"); %>
		<table cellpadding="2" border="3">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Course</th>
				<th>Faculty Name</th>
				<th>Description</th>
				<th>Ratings</th>
			</tr>
			<%for(FeedBack feedBack:lFeedBacks){ %>
			<tr>
				<th><%=feedBack.getId() %></th>
				<th><%=feedBack.getName() %></th>
				<th><%=feedBack.getCourseName() %></th>
				<th><%=feedBack.getFacultyName()%></th>
				<th><%=feedBack.getDescription()%></th>
				<th><%=feedBack.getRatings()%></th>
			</tr>
			<%} %>
		</table>
</body>
</html>