<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update a Film</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<h1 ><a href="index.html" id="id" >MVC Home Directory</a></h1>

	<form action="updateFilm.do" method="POST">

		<h1>Update a Film</h1>
		
		
		Change any of the following fields of your film:
		
		<br>
		
		(If any of the fields need to be kept the same, do not change them).
		
		<br>
		<input type="hidden" name="id" value="${film.id}"/>
		Name: <input type="text" name="title" value="${film.title}"/> 
		<br> 
		Description: <input type="text" name="description" value="${film.description}"/>
		<br> 
		Release year: <input type="text" name="releaseYear" value="${film.releaseYear}"/>
		<br> 
		Rental duration: <input type="text" name="rentalDuration" value="${film.rentalDuration}"/>
		<br> 
		Rental rate: <input type="text" name="rentalRate" value="${film.rentalRate}"/>
		<br> 
		Length: <input type="text" name="length" value="${film.length}"/>
		<br> 
		Replacement cost: <input type="text" name="replacementCost" value="${film.replacementCost}"/>
		<br> 
		Rating: <input type="text" name="rating" value="${film.rating}"/>
		<br> 
		Special Features: <input type="text" name="specialFeatures" value="${film.specialFeatures}"/>
		<br>
		
		<input type="submit" value="submit" />

	</form>

</body>
</html>
