<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Actor Display</title>
<link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<h1>
		<a href="index.html" id="id">MVC Film Directory</a>
	</h1>
	<br>
	<br>
	<h1>Actor Display</h1>
	<c:choose>
		<c:when test="${! empty actor }">
			<ul>
				<li>Actor ID: ${ actor.id}</li>
				<li>Name: ${ actor.fullName}</li>
			</ul>
			
			<form action="actorUpdatePage.do" method="GET">
					<input type="hidden" name="id" value="${actor.id}">
					<input type="submit" name="submit" value="Update actor">
				</form>
				
				<form action="deleteActor.do" method="POST">
					<input type="hidden" name="id" value="${actor.id}">
					<input type="submit" name="submit" value="Delete actor">
				</form>
		</c:when>
		<c:otherwise>
			<p>No actor found</p>
			<br>
			<p>Please try again</p>


		</c:otherwise>

	</c:choose>

</body>
</html>