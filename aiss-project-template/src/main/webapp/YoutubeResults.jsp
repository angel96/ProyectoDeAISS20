<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" name="viewport"
	content="width=device-width, initial-scale=1" charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Busqueda Youtube</title>
</head>
<body style="background-color: #000">

	<nav id="navbar">

	<form id="return" action="/tmdbsearchcontroller" method="post">
		<input type="hidden" name="query" value=""> <input
			type="submit" id="return" value="VOLVER">
	</form>

	<form id="formSearch" action="/DriveFilePostController" method="post">
		<input type="hidden" id="array" name="array" value=""> <input
			type="submit" id="searchBtn" value="GUARDAR EN DRIVE">
	</form>

	</nav>
	<iframe id="iframe" width="900" height="600"
		src="https://www.youtube.com/embed/${x}/>" frameborder="0"
		allowfullscreen></iframe>

	<button class="save" id="add" onclick="add()">GUARDAR</button>

	<div class="select">

		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>

		<c:forEach items="${requestScope.videos}" var="x">
			
			<img class="images" id="${x.id.videoId}"
				src="https://i.ytimg.com/vi/${x.id.videoId}/movieposter.jpg"
				width="260" onclick="select('${x.id.videoId}')">
		</c:forEach>

		<a class="next" onclick="plusSlides(1)">&#10095;</a>

	</div>

	<label>Seleccionados</label>
	<table id="seleccionados">
		<c:forEach items="${requestScope.ids}" var="y">
			<tr>
				<td><img src='https://img.youtube.com/vi/${y}/0.jpg' width='50'></td>
				<td>https://www.youtube.com/embed/${y}/</td>
				<td><button onclick='remove(this)'>x</button></td>
				<td style="display: none">${y}</td>
			</tr>
		</c:forEach>
	</table>

	<script type="text/javascript">
		var selected = [];
		var count;
		function select(id) {
			document.getElementById("iframe").src = "https://www.youtube.com/embed/"
					+ id + "/>";
			document.getElementById("iframe").style.display = "block";
			document.getElementById("add").style.display = "block";
			document.getElementById("add").setAttribute('onclick',
					"add('" + id + "')");
			
			count = 0;
			for (i = 0; i < selected.length; i++) {
				if (selected[i] == id) {
					count++;
				}
			}
			if (count > 0) {
				document.getElementById("add").firstChild.data = "GUARDADO";
			} else {
				document.getElementById("add").firstChild.data = "GUARDAR";
			}

		}
		window.onload = function(){
			if(typeof(Storage)!=="undefined"){
				selected = selected.concat(sessionStorage.getItem("selected").split("#"));
				
				var cleanSelected = new Array();
				for(i=0;i<selected.length;i++){
					if(selected[i]){
						cleanSelected.push(selected[i]);
					}
					
				}
				selected = cleanSelected;
				storage();
				
			}else{
				alert("Sin almacenamiento local");
			}
		}

		function add(id) {

			var count = 0;
			for (i = 0; i < selected.length; i++) {
				if (selected[i] == id) {
					count++;
				}
			}
			if (count > 0) {
				for (i = 0; i < selected.length; i++) {
					if (selected[i] == id) {
						document.getElementById("add").firstChild.data = "GUARDAR";
						selected.splice(i, 1);
					}
				}
				

			} else {

				document.getElementById("add").firstChild.data = "GUARDADO";
				selected.push(id);
			}
			
			storage();
		}

		function storage() {
			if (typeof (Storage) !== "undefined") {
				sessionStorage.setItem("selected", selected.join("#"));
				document.getElementById("array").value = selected.join("#");

			} else {
				alert("Sin almacenamiento local");
			}
		}

		var slideIndex = 1;
		showSlides(slideIndex);

		function plusSlides(n) {
			showSlides(slideIndex += n);
		}

		function currentSlide(n) {
			showSlides(slideIndex = n);
		}

		function showSlides(n) {
			var i;
			var slides = document.getElementsByClassName("images");
			if (slides.length < 9) {
				for (i = 0; i < slides.length; i++) {
					slides[i].style.display = "block";
					document.getElementsByClassName("prev")[0].style.display = "none";
					document.getElementsByClassName("next")[0].style.display = "none";
				}
			} else {
				if (n > slides.length - 8) {
					slideIndex = 1
				}
				if (n < 1) {
					slideIndex = slides.length - 8
				}
				for (i = 0; i < slides.length; i++) {
					slides[i].style.display = "none";
				}
				slides[slideIndex - 1].style.display = "block";
				slides[slideIndex].style.display = "block";
				slides[slideIndex + 1].style.display = "block";
				slides[slideIndex + 2].style.display = "block";
				slides[slideIndex + 3].style.display = "block";
				slides[slideIndex + 4].style.display = "block";
				slides[slideIndex + 5].style.display = "block";
				slides[slideIndex + 6].style.display = "block";
				slides[slideIndex + 7].style.display = "block";
			}
		}
	</script>

</body>
</html>
