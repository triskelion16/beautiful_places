<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Beautiful Places</title>
	<meta name="description" content="">
	<meta name="keywords" content="">

	<meta name="viewport" content="width=device-width, initial-scale=0.6">

	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Merriweather:300,400" rel="stylesheet">
	
	<link href='<spring:url value="/resources/css/css_reset.css"/>' rel="stylesheet" />	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />

</head>
<body class="form">
	<div class="container"><br>
		<h2>Edytuj post</h2>

		<form:form method="post" modelAttribute="places" enctype="multipart/form-data">

			<div class="form-group">
				<label> Nazwa: 
					<form:input class="form-control" path="name" />
					<form:errors path="name" cssClass="error" />
				</label>
			</div>

			<div class="form-group">
				<label> Opis: 
					<form:textarea rows="5" cols="50" type="text" class="form-control" path="description" />
					<form:errors path="description" cssClass="error" />
				</label>
			</div>
			
			<div class="form-group">
				<label> Szczegóły: 
					<form:textarea rows="15" cols="50" type="text" class="form-control" path="details" />
					<form:errors path="details" cssClass="error" />
				</label>
			</div>
			
			<div class="form-group">
				<label> Kontynent: <form:select itemLabel="name" itemValue="id" class="form-control" path="continent.id" items="${continents}" />
				</label>
			</div>

			<div class="form-group">
				<label> Obraz: 
					<form:input id="jpg" class="form-control" path="jpgPath" />
				</label>
			</div>

			<input type="submit" class="btn btn-default" value="Edytuj">

		</form:form>

	</div>

</body>
</html>