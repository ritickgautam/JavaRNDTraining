<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 .topcorner{
   position:absolute;
   top:0;
   right:0;
  }
  .topleft{
   position:static;
   top:0;
   left:0;
  }
</style>
</head>
<body>
<div class = "topleft"><h2>Product Management</h2></div>
<c:if test="${sessionScope.user.id!=null}">
<div class="topcorner">
<h2 align="right">Welcome ${sessionScope.user.name}</h2>
</div>
</c:if>

</body>
</html>