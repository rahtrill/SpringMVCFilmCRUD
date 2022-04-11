<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Film Display</title>
<link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1 ><a href="index.html" id="id" >MVC Home Directory</a></h1>


	<h1>Film Display</h1>
	<c:choose>
		<c:when test="${! empty film }">
			<ul>
				<li>Title: ${ film.title}</li>
				<li>Description: ${ film.description}</li>
				<li>Release Year: ${ film.releaseYear}</li>
				<li>${ film.languageList}</li>
				<li>Rental Duration: ${ film.rentalDuration}</li>
				<li>Rental Rate: ${ film.rentalRate}</li>
				<li>Film Length: ${ film.length}</li>
				<li>Replacement Cost: ${ film.replacementCost}</li>
				<li>Rating: ${ film.rating}</li>
				<li>Special Features: ${ film.specialFeatures}</li>
				<li>Cast: ${ film.actorList}</li>
				

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