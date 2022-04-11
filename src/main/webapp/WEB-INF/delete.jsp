<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Deleted Film Display</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<h1>
		<a href="index.html" id="id">MVC Film Directory</a>
	</h1>
	<br>
	<br>

	<h1>The Following Film Has Been Deleted:</h1>
	<c:choose>
		<c:when test="${! empty film }">
			<ul>
				<li>${ film.title}</li>
				<li>${ film.description}</li>
				<li>${ film.releaseYear}</li>
				<li>${ film.languageId}</li>
				<li>${ film.rentalDuration}</li>
				<li>${ film.rentalRate}</li>
				<li>${ film.length}</li>
				<li>${ film.replacementCost}</li>
				<li>${ film.rating}</li>
				<li>${ film.specialFeatures}</li>

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