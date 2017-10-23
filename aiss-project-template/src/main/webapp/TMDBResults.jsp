<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Búsqueda-TMDB</title>
</head>
<body>


	<div class="container">
		<form id="formSearch" action="tmdbsearchcontroller" method="post">
			<input type="hidden" id="ids" name="ids"
				value="<c:forEach items="${requestScope.ids}" var="y">${y}#</c:forEach>">
			<input type="hidden" id="selected" name="selected"
				value="<c:forEach items="${requestScope.before}" var="y">${y}#</c:forEach>">
			<input type="text" name="query" placeholder="Buscar películas"
				required /> <input type="submit" name="searchTMDBbtn"
				title="search" value="Buscar">
		</form>

	</div>

	<div class="container" id="select1">
		<c:forEach items="${requestScope.results}" var="x">
			<div class="row" id="row-${x.id}">
				<div class="col-md-3">

					</br> <img src="https://image.tmdb.org/t/p/w185${x.poster_path}" /></br>
				</div>
				<div class="col-md-9">
					<h3>
						<c:out value="${x.title}" />
					</h3>
					<p align="justify">
						<c:out value="${x.overview}" />
					</p>
					</br>
					<button id="button-${x.id}"
						onclick="button_action(${x.id},'${x.title}')">Añadir</button>
				</div>
			</div>
		</c:forEach>
	</div>


	<!--RESULTADOS DE TMDB: SE MUESTRAN LOS SELECCIONADOS-->
	<div class="seleccionados">
		<label>Seleccionados</label>
		<form id="formSearchYoutube" action="/youtubesearchcontroller"
			method="post">
			<input type="hidden" id="ids" name="ids"
				value="<c:forEach items="${requestScope.ids}" var="y">${y}#</c:forEach>">
			<input type="hidden" id="array" name="array" value=""> <input
				type="submit" id="searchBtn" name="searchBtn" title="search"
				value="Buscar" onclick="">
		</form>
	</div>





	<!-- PRUEBA -->

	<!-- FIN PRUEBA -->
	<script type="text/javascript">
	
	var ids = [], names = [];
	var i;
	
	window.onload = function(){
		if(typeof(Storage)!=="undefined"){
			names = names.concat(sessionStorage.getItem("names").split("#"));
			ids = ids.concat(sessionStorage.getItem("oldIds").split("#"))
		}else{
			alert("Sin almacenamiento local");
		}
		var c = document.getElementsByClassName("row");
		for(i=0;i<c.length;i++){
			var a = (c[i].id.substring(4)); 
			if(ids.indexOf(a)>-1){
				document.getElementById("button-"+a).firstChild.data = "Añadido";
				document.getElementById("button-"+a).style.background = '#46db39';	
			}else{
				document.getElementById("button-"+a).firstChild.data = "Añadir";
				document.getElementById("button-"+a).style.background = 'none';	
			}
		}
	}

	function button_action(a,n) {
		var count=0;
		for(i=0; i<ids.length; i++){
			if(ids[i]==a){
				count++;
			}
		}
		if(count > 0){
			for(i=0; i<ids.length; i++){
				if(ids[i]==a){
					document.getElementById("button-"+a).firstChild.data = "Añadir";
					document.getElementById("button-"+a).style.background = 'none';
					ids.splice(i,1);
					names.splice(i,1);	
					}
				}
			storage();
			
		}else{
			document.getElementById("button-"+a).firstChild.data = "Añadido";
			document.getElementById("button-"+a).style.background = '#46db39';
			ids.push(a);
			names.push(n);	
			storage();
		}		
	};

	function storage(){
		if(typeof(Storage)!=="undefined"){
			sessionStorage.setItem("names",names.join("#"));
			sessionStorage.setItem("oldIds",ids.join("#"));
			alert(sessionStorage.getItem("names"));
			
		}else{
			alert("Sin almacenamiento local");
		}	
	}
		
	</script>
</body>
</html>
