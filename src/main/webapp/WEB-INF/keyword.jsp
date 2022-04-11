<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Keyword Film Display</title>
<link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1>
		<a href="index.html" id="id">MVC Film Directory</a>
	</h1>
	<br>
	<br>
	<h1>Films:</h1>
	
	<c:choose>
	
	<c:when test="${! empty film}">
		<ul>
			<c:forEach var="f" items="${film}">
					<li><p><a href="findByID.do?id=${f.id}" class ="keyword">ID: ${f.id} Title: ${f.title} </a></p></li>
			</c:forEach>
		</ul>
	
	</c:when>
	
	<c:otherwise>
	
		<h2>No film found matching your search.</h2>
	
	</c:otherwise>
	
	</c:choose>
	
</body>
</html>