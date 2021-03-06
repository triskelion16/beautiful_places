<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
    </head>
    <body>
        
       <!--********* NAVIGATOR **********************************************-->
        <nav><br>
            <div>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li class="zmedia"><a href="#africa">Afryka</a></li>
                    <li class="zmedia"><a href="#america">Ameryka</a></li>
                    <li class="zmedia"><a href="#australia">Australia</a></li>
                    <li class="zmedia"><a href="#asia">Azja</a></li>
                    <li class="zmedia"><a href="#europe">Europa</a></li>
                </ul>
            </div>
        </nav>
        
        <!--********* HEADER **********************************************-->
        <header id="banner" >
            <div class="background">
       		 <a href="/BeautifulPlaces/admin"><button>Zaloguj się</button></a>
                <div class="main">
                    <div class="post">
                        <h1>BEAUTIFUL PLACES</h1><br><br>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras a tincidunt magna. Morbi ac ultricies mi, at condimentum nisl. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla in lobortis ipsum. Donec eget enim varius, vehicula magna non, faucibus nibh. Sed viverra sit amet risus a eleifend. Donec sed dui ac mauris porta tempor vel non nunc. Duis tincidunt accumsan lectus, et maximus libero luctus in. Fusce consequat nisi non tincidunt interdum. Aliquam eget libero vel nunc tincidunt vestibulum eu et velit.
                        </p>
                    </div>
                </div>

            </div>
        </header>
        
        <!--********* AFRICA **********************************************-->
        <section class="blog" id="africa">
            <div class="post">
                <h2>&gt;&gt;&gt;&nbsp;AFRYKA&nbsp;&lt;&lt;&lt;</h2>
				
				<c:forEach var="africa" items="${africa}">
				
                	<strong class="title">${africa.name}</strong>
                	
                	<div class="images">
                		<c:if test="${africa.jpg != null}">
	                   		<div class="image-container">
	                   			<a href="<c:url value="/details/${africa.id}"/>">
	                   				<img src="data:image/jpg;base64,${africa.jpg}" />
	                   			</a>
	                   	 	</div>
	                   	 </c:if>
               	    </div>
               	    
               	    <p>${africa.description}</p>
               	    
                </c:forEach>

            </div>
        </section>
      
      <!--********* AMERICA **********************************************-->
        <section class="blog" id="america">
            <div class="post">
                <h2>&gt;&gt;&gt;&nbsp;AMERYKA&nbsp;&lt;&lt;&lt;</h2>

				<c:forEach var="america" items="${america}">
				
                	<strong class="title">${america.name}</strong>
                	
                	<div class="images">
                		<c:if test="${america.jpg != null}">
	                   		<div class="image-container">
	                   			<a href="<c:url value="/details/${america.id}"/>">
	                   				<img src="data:image/jpg;base64,${america.jpg}" />
	                   			</a>
	                   	 	</div>
	                   	 </c:if>
               	    </div>
               	    
               	    <p>${america.description}</p>
               	    
                </c:forEach>

            </div>
        </section>
        
        <!--********* AUSTRALIA **********************************************-->
        <section class="blog" id="australia">
            <div class="post">
                <h2>&gt;&gt;&gt;&nbsp;AUSTRALIA&nbsp;&lt;&lt;&lt;</h2>

				<c:forEach var="australia" items="${australia}">
				
                	<strong class="title">${australia.name}</strong>
                	
                	<div class="images">
                		<c:if test="${australia.jpg != null}">
	                   		<div class="image-container">
	                   			<a href="<c:url value="/details/${australia.id}"/>">
	                   				<img src="data:image/jpg;base64,${australia.jpg}" />
	                   			</a>
	                   	 	</div>
	                   	 </c:if>
               	    </div>
               	    
               	    <p>${australia.description}</p>
               	    
                </c:forEach>

            </div>
        </section>
        
         <!--********* ASIA **********************************************-->
        <section class="blog" id="asia">
            <div class="post">
                <h2>&gt;&gt;&gt;&nbsp;AZJA&nbsp;&lt;&lt;&lt;</h2>

				<c:forEach var="asia" items="${asia}">
				
                	<strong class="title">${asia.name}</strong>
                	
                	<div class="images">
                		<c:if test="${asia.jpg != null}">
	                   		<div class="image-container">
	                   			<a href="<c:url value="/details/${asia.id}"/>">
	                   				<img src="data:image/jpg;base64,${asia.jpg}" />
	                   			</a>
	                   	 	</div>
	                   	 </c:if>
               	    </div>
               	    
               	    <p>${asia.description}</p>
               	    
                </c:forEach>

            </div>
        </section>
        
        <!--********* EUROPA **********************************************-->
        <section class="blog" id="europe">
            <div class="post">
                <h2>&gt;&gt;&gt;&nbsp;EUROPA&nbsp;&lt;&lt;&lt;</h2>
                
                <c:forEach var="europe" items="${europe}">
				
                	<strong class="title">${europe.name}</strong>
                	
                	<div class="images">
                		<c:if test="${europe.jpg != null}">
	                   		<div class="image-container">
	                   			<a href="<c:url value="/details/${europe.id}"/>">
	                   				<img src="data:image/jpg;base64,${europe.jpg}" />
	                   			</a>
	                   	 	</div>
	                   	 </c:if>
               	    </div>
               	    
               	    <p>${europe.description}</p>
               	    
                </c:forEach>

            </div>
        </section>
        
        <!--********* FOOTER **********************************************-->
        <footer>
            <a href="#"><span>&copy;PW-JavaEE - Projekt końcowy 2019</span></a><br>
        </footer>
        
    </body>
</html>