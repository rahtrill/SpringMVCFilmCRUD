<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Film Display</title>
</head>
<body>

	<h1>Film Display</h1>
	<c:choose>
		<c:when test="${! empty film }">
			<ul>
				<li>${ film.title}</li>
				<li>${ film.description}</li>
				<li>${ film.languageId}</li>
				<li>${ film.rentalRate}</li>
				<li>${ film.length}</li>


			</ul>


		</c:when>
		<c:otherwise>
			<p>No film found</p>
			<br>
			<p>Please try again</p>


		</c:otherwise>

	</c:choose>




</body>
</html>