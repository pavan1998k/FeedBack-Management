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
<h1 align="center">Welcome To Home Page</h1><br>
<ul>
  <li><a href="RegisterAdmin.jsp">Register Admin</a></li>
  <li><a href="CoordinateLogin.jsp">Login Co-ordinate</a></li>
  <li><a href="CreateParticipant.jsp">Register Participants</a></li>
</ul>

</body>
</html>