<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer View</title>
</head>
<body>

<h2>
<a href="..">Home</a></h2> <h2 align="right">Logged In successfully: ${customer.name}</h2>
<hr>
<a href="../car/addCar">Add car</a><br><br>
<a href="../car/listCar">List of Registered cars by ${customer.name}</a><br><br>
<a href="../car/listCar">List of cars available for Booking</a><br><br>
<a href="../car/bookCar">Book car</a><br><br>
	
</body>
</html>