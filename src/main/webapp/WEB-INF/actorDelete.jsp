<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Deleted Actor Display</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>

	<h1>The Following Actor Has Been Deleted:</h1>
	<c:choose>
		<c:when test="${! empty actor }">
			<ul>
				<li>${actor.id}</li>
				<li>${actor.fullName}</li>
			</ul>

		</c:when>
		<c:otherwise>
			<p>No actor found</p>
			<br>
			<p>Please try again</p>


		</c:otherwise>

	</c:choose>

</body>
</html>