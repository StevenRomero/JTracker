<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Upload Video</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>
<form action="uploadVideo" method="post">
  Title: <input type="text" name="title" id="title"/><br />
  Game:  <input type="text" name="game" id="game"/><br />
  Video: <input type="file" name="video" accept="video/*" multiple="multiple"/>
  <input type="submit" value="Submit" />
</form> 
</body>
</html>