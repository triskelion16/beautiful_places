<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Beatiful Places</title>
	<meta name="description" content="">
	<meta name="keywords" content="">

	<meta name="viewport" content="width=device-width, initial-scale=0.6">

	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Merriweather:300,400" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/css_reset.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	
	$(function(){
	 $('#fiad1').change( function(event) {
	 	var tmppath = URL.createObjectURL(event.target.files[0]);
	 	$("img").fadeIn("slow").attr('src',tmppath);
	 	console.log(tmppath);
	 	});
	 });   
	 
	</script>

</head>
<body>
	<div class="container">
		<h2>Dodaj nowy post</h2>

		<form:form method="post" modelAttribute="places" enctype="multipart/form-data">

			<div class="form-group">
				<label> Nazwa: <form:input class="form-control" path="name" />
				</label>
			</div>

			<div class="form-group">
				<label> Opis: <form:textarea rows="5" cols="50" type="text" class="form-control" path="description" />
				</label>
			</div>

			<div class="form-group">
				<label> Kontynent: <form:select itemLabel="name"
						itemValue="id" class="form-control" path="continent.id"
						items="${continents}" />
				</label>
			</div>

			<div class="form-group">
				<label> Obraz: <form:input id="jpg" class="form-control" path="jpgPath" />
				</label>
			</div>
			

			<input type="submit" class="btn btn-default" value="Dodaj">

		</form:form>


	</div>

	<script type="text/javascript">
		var path = (window.URL || window.webkitURL).createObjectURL(file);
		console.log('path', path);
	</script>
	
</body>
</html>