<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Language Id</th>
					<th>Language Name</th>
					<th>Countries where Spoken</th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="language" items="${sessionScope.languages}"
					varStatus="c">
					<tbody>
						<tr>
							<td>${c.count}</td>
							<td>${language.name}</td>
							<td><c:forEach var="country" items="${language.getCountries()}">
								${country.getName()}
							</c:forEach></td>

							<td><a href="editLanguage?act=#">Edit | </a> <a
								href="deleteLanguage?act=#">Delete</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>