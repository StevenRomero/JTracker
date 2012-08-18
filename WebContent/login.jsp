<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>-->
<!DOCTYPE html>
<html>
<head>
<title>Login to JTracker</title>
<link rel="stylesheet" type="text/css" href="style/form.css" />
<link type="text/css" href="css/sunny/jquery-ui-1.8.23.custom.css" rel="stylesheet" />

</head>
<body>
	<div class="ui-widget-header ui-corner-top form_pad">
      	<h2>Log in to JTracker</h2>
  		<h3>Fill out the form below and click "Login" to Login</h3>
	</div>
	<form action="login" method="post" id="form" name="form">

		<div class="ui-widget-content form_pad">
		<h3>Log in</h3>
		</div>
		
		<div class="ui-widget-content form_pad">
			<h3>Enter username:</h3>
			<input type="text" name="username" id="username"/>
				

			<h3>Enter password:</h3>
			<input type="password" name="password" id="password"/>  
			
			<br> 
			
			</br>
			
			<input type="submit" value="Login" />  
			
			<br> 
			
			</br>
				
		</div>
			
		<div class="ui-widget-header ui-corner-bottom form_pad">
			<br> 
			
			</br>
		</div>
	</form>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/login_gui.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.23.custom.min.js"></script>
</body>
</html>