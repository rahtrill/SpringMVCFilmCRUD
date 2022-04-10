<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Keyword Film Display</title>
</head>
<body>

	<h1>Films:</h1>
	
		<ul>
	<c:forEach var="f" items="${film}">
			<li><p><a href="findByID.do?id=${f.id}">ID: ${f.id} Title: ${f.title} Description: ${f.description} </a></p></li>
	</c:forEach>
		</ul>
	
</body>
</html>