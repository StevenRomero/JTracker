<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register User</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>
<form action="register" method="post">
  First name: <input type="text" name="firstName" id="firstName"/><br />
  Last name:<input type="text" name="lastName" id="lastName"/><br />
  Email: <input type="email" name="email" id="email"/><br />
  User Name:<input type="text" name="userName" id="userName"/><br />
  Password: <input type="password" name="password" id="password"/><br />
  
  <input type="submit" value="Submit" />
</form> 
</body>
</html>