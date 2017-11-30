<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Búsqueda-TMDB</title>
</head>
<body style="background-color:#F4F4F4">


	<nav id="navbar" style="border-bottom: 2px solid #bc0009;">
	
	<form id="youtubeSearch" action="/youtubesearchcontroller"
			method="post">
			<input type="hidden" id="array" name="array" value=""> 
			<input type="submit" id="youtube" value="BUSCAR EN YOUTUBE">
		</form>
		
	<form id="tmdbSearch" action="tmdbsearchcontroller" method="post">
		<input type="text" name="query" placeholder="Buscar películas"
			required /> 
			<input type="submit" value="BUSCAR">
	</form>
	</nav>

	<div id="selected">
		<div id="movieList"></div>
		
		<button id="close"
			onclick="document.getElementById('selected').style.display='none';document.getElementById('open').style.display='block'">&#x02C6</button>
	</div>

	<button id="open"
		onclick="document.getElementById('selected').style.display='block';this.style.display='none'">&#x02C7</button>

	<div id="movies">
		<c:forEach items="${requestScope.results}" var="x">
			<article class="movie">
			<div class="box">
				<div class="row" id="row-${x.id}">
					<div class="col1">
						<c:choose>
							<c:when test="${empty x.poster_path}">
								<img src="/images/no-image.jpg" />
							</c:when>
							<c:otherwise>
								<img src="https://image.tmdb.org/t/p/w185${x.poster_path}" />
							</c:otherwise>
						</c:choose>

					</div>
					<div class="col2">
						<article>
						<h3>
							<c:out value="${x.title}" />
						</h3>
						<p align="justify">
							<c:set var="p" value="${x.overview}" />
							<c:choose>
								<c:when test="${fn:length(p) >= 400}">
									<c:set var="sub" value="${fn:substring(p,0,400)}" />
					${sub}...
					</c:when>
								<c:otherwise>
									<c:out value="${x.overview}" />
								</c:otherwise>
							</c:choose>
						</p>
						</article>
					</div>
				</div>
				<button class="add" id="button-${x.id}"
					onclick="button_action(${x.id},'${x.title}','${x.poster_path}')">AÑADIR</button>
			</div>
			</article>
		</c:forEach>
	</div>

	<script type="text/javascript">
	
	var ids = [], names = [];poster = [];
	var i;
	var movieList = document.getElementById("movieList");
	
	
	
	window.onload = function(){
		if(typeof(Storage)!=="undefined"){
			names = names.concat(sessionStorage.getItem("names").split("#"));
			ids = ids.concat(sessionStorage.getItem("oldIds").split("#"));
			poster = poster.concat(sessionStorage.getItem("oldPoster").split("#"));
			var cleanNames = new Array();
			var cleanIds = new Array();
			var cleanPoster = new Array();
			for(i=0;i<10;i++){
				if(names[i]){
					cleanNames.push(names[i]);
				}
				if(ids[i]){
					cleanIds.push(ids[i]);
				}
				if(poster[i]){
					cleanPoster.push(poster[i]);
				}
			}
			names = cleanNames;
			ids = cleanIds;
			poster = cleanPoster;
			
		}else{
			alert("Sin almacenamiento local");
		}
		document.getElementById("array").value = names.join("#");
		var c = document.getElementsByClassName("row");
		for(i=0;i<c.length;i++){
			var a = (c[i].id.substring(4)); 
			if(ids.indexOf(a)>-1){
				document.getElementById("button-"+a).firstChild.data = "AÑADIDO";	
			}else{
				document.getElementById("button-"+a).firstChild.data = "AÑADIR";	
			}
		}
		movie_list();
	}

	function button_action(a,n,p) {
		
		
			var count=0;
			for(i=0; i<ids.length; i++){
				if(ids[i]==a){
					count++;
				}
			}
			if(count > 0){
				for(i=0; i<ids.length; i++){
					if(ids[i]==a){
						document.getElementById("button-"+a).firstChild.data = "AÑADIR";
						ids.splice(i,1);
						names.splice(i,1);	
						poster.splice(i,1);	
						}
					}
				storage();
				
			}else{
				if(ids.length >= 7){
					alert("NO PUEDEN REALIZARSE MÁS DE 7 SELECCIONES");
				}else{
				document.getElementById("button-"+a).firstChild.data = "AÑADIDO";
				ids.push(a);
				names.push(n);	
				poster.push(p);	
				storage();
			}	
		}
			movie_list();
	};

	function storage(){
		if(typeof(Storage)!=="undefined"){
			sessionStorage.setItem("names",names.join("#"));
			sessionStorage.setItem("oldIds",ids.join("#"));
			sessionStorage.setItem("oldPoster",poster.join("#"));
			document.getElementById("array").value = names.join("#");
			
		}else{
			alert("Sin almacenamiento local");
		}	
	}
	
	function movie_list(){
		movieList.innerHTML = "";
		if(poster.length > 0){
			for(i=0;i<poster.length;i++){
				movieList.innerHTML += "<img src='https://image.tmdb.org/t/p/w185"+poster[i]+"'/>";
				document.getElementById("youtube").style.display = 'flex';
			}
		}else{
			movieList.innerHTML = "<h1>NO HAY PELÍCULAS SELECCIONADAS</h1>"
			document.getElementById("youtube").style.display = 'none';
		}
	}
	
		
	</script>
</body>
</html>
