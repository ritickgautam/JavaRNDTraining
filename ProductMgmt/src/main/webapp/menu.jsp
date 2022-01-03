<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.user.id==null}">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li ><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
      <li><a href="aboutUs.jsp">About Us</a></li>
      <li><a href="contactUs.jsp">Contact</a></li>
    </ul>
  </div>
</nav>
</c:if>
<c:if test="${sessionScope.user.id!=null}">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li ><a href="${pageContext.request.contextPath}/user-home.jsp">Home</a></li>
      <li><a href="aboutUs.jsp">About Us</a></li>
      <li><a href="user-home.jsp?act=add">Add Product Details</a></li>
      <li><a href="user-home.jsp?act=show">Show Report</a></li>
      <li><a href="logout">Logout</a></li>
    </ul>
  </div>
</nav>
</c:if>

  
</body>
</html>