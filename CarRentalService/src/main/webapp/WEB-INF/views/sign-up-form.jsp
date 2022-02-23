<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
.custab {
	border: 1px solid #ccc;
	padding: 5px;
	margin: 5% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}

.main {
	margin-top: 100px;
}

.header {
	height: 80px;
	width: 50%;
	background-color: #f4511e;
	color: #ffffff;
	margin-left: 300px;
	margin-top: 50px;
	padding-top: 5px;
	padding-left: 20px;
}

.hr {
	background-color: #f4511e;
	height: 10px;
}

.a {
	background-color: #f4511e; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
	font-size: 20px;
}

.addButton {
	padding-left: 800px;
	}
</style>
<meta charset="ISO-8859-1">
<title>Create Customer</title>
</head>
<body>

<h2>
<a href="..">Home</a></h2>
<hr>
<div class="header">
		<h1 align="center">Customer SignUp</h1>
	</div>
	<hr class="hr">
	 
	<div class="container main">
		<div class="row col-md-6 col-md-offset-2 custyle">
			<div>
				 <form:form action="saveCustomer" modelAttribute="customer"
					method="POST">
					<form:hidden path="userId" />
					<table class="table table-striped custab">
						<tr>
							<th>Name:</th>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<th>Email:</th>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<th>Password:</th>
							<td><form:input path="password" /></td>
						</tr>
						<tr>
							<th>Contact:</th>
							<td><form:input path="contact" /></td>
						</tr>
						<tr>
							<th>Address: </th>
							<td><form:input path="address" /></td>
						</tr>
						<td colspan="2" align="center"><input type="submit"
							class="btn btn-success btn-lg" value="Create Account"></td>
						<tr>
						</tr>
					</table> 
				</form:form>
			</div>

		</div>
	</div>

</body>
</html>