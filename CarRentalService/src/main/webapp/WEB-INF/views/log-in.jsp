<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title></head>
<body>

<h2>
<a href="..">Home</a></h2>
<hr>
<h3>${message }</h3>
<div class="header">
		<h1 align="center">Customer LogIn</h1>
	</div>
	<hr class="hr">
	 
	<div align="center">
		<form action="authenticate" method="post" onsubmit="return checkForm(this)">
			<div class="loginInp">
				<div class="form-group">
					<label for="Email">Email</label><input type="text"
						class="form-control" name="email" placeholder="E-mail"
						maxlength="30">
				</div><br>
				<div class="form-group">
					<label for="password">Password</label><input
						type="password" class="form-control" name="password"
						placeholder="Password" maxlength="30">
				</div>
				<button type="submit" class="btn btn-primary" name="command"
					value="Authentification">Sign In</button>
			</div>

		</form>
	</div>

</body>
</html>