<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Profile Page</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>

<p>User Name:</p> <p>${sessionScope.username}</p> <br />

<p>Email Address:</p> <p>${sessionScope.emailAddress}</p>  <br />

</body>
</html>