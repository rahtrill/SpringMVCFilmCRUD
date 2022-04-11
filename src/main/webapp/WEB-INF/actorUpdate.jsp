<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update an Actor</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>

	<form action="updateActor.do" method="POST">

		<h1>Update an Actor</h1>
		
		
		Change any of the following fields of your actor:
		
		<br>
		
		(If any of the fields need to be kept the same, do not change them).
		
		<br>
		<input type="hidden" name="id" value="${actor.id}"/>
		First Name: <input type="text" name="firstName" value="${actor.firstName}"/> 
		<br> 
		Last Name: <input type="text" name="lastName" value="${actor.lastName}"/>
		<br> 
		
		<input type="submit" value="submit" />

	</form>

</body>
</html>
