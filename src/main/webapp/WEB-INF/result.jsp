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
				<li>${ film.releaseYear}</li>
				<li>${ film.languageId}</li>
				<li>${ film.rentalDuration}</li>
				<li>${ film.rentalRate}</li>
				<li>${ film.length}</li>
				<li>${ film.replacementCost}</li>
				<li>${ film.rating}</li>
				<li>${ film.specialFeatures}</li>

			</ul>
			
			<form action="filmUpdatePage.do" method="GET">
					<input type="hidden" name="id" value="${film.id}">
					<input type="submit" name="submit" value="Update Film">
				</form>
				
					<c:choose>
	
			<c:when test="${film.id <= 1000}">
				<br>
				<br>
				Cannot delete this film
			</c:when>
	
			<c:otherwise>
				<form action="deleteFilm.do" method="POST">
					<input type="hidden" name="id" value="${film.id}">
					<input type="submit" name="submit" value="Delete Film">
				</form>
			</c:otherwise>

	</c:choose>


		</c:when>
		<c:otherwise>
			<p>No film found</p>
			<br>
			<p>Please try again</p>


		</c:otherwise>

	</c:choose>

</body>
</html>