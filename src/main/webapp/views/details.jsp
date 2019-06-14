<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--****************************************************************************************************-->
<!--                                    Autor: Marcin                                                   -->
<!--****************************************************************************************************-->

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
<link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />

</head>
<body>

	<!--********* NAVIGATOR **********************************************-->
	<nav>
		<br>
		<div>
			<ul>
				<li><a href="/BeautifulPlaces/">Powrót</a></li>
			</ul>
		</div>
	</nav>

	<!--********* HEADER **********************************************-->
	<header>
		<div class="image-container">
			<img src="data:image/jpg;base64,${places.jpg}" />
		</div>
	</header>

	<!--********* SECTION **********************************************-->
	<section class="blog">
		<div class="post">

			<span id="h1">${places.name}</span><br>
			<span id="h5">${places.description}</span><br><br>

			<p id="details">${places.details}</p>
		</div>
	</section>

	
	<!--********* FOOTER **********************************************-->
	<br><br>
	<footer>
		<a href="#"><span>&copy;PW-JavaEE - Projekt końcowy 2019</span></a><br>
	</footer>

</body>
</html>