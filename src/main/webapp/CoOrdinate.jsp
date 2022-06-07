<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
</head>
<body>

<ul>
  <li><a class="active" href="CoOrdinateCreate.jsp">Create Co-ordinates</a></li>
  <li><a href="viewCoordinate">View Co-ordinates</a></li>
  <li><a href ="HomePage.jsp">Home</a></li>
</ul>
<%@include file = "CoOrdinateCreate.jsp" %>
</body>
</html>