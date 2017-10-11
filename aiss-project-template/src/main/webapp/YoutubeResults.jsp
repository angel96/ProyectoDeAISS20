<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> -->
  <!-- <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busqueda Youtube</title>
</head>
<body>
	<fieldset id="Youtube">
		
			<iframe id="previo" src="https://www.youtube.com/embed/${x}/>" 
			frameborder="0" allowfullscreen></iframe>
			<button id="add" onclick="add()"> Añadir a seleccionados</button>
		
			<div class="seleccionar"> 
			<c:forEach items="${requestScope.videos}" var="x">
					<img id="img" src="https://img.youtube.com/vi/${x}/0.jpg" width="260"  
					onclick="seleccionar('${x}')">
				</c:forEach>
			
		</div>
	</fieldset>

	<fieldset id="TMDB">
		
			<label>Seleccionados</label>
			<table id="seleccionados"></table>
			<button onclick="table()">Mostrar</button>
			
			
			<form id="formSearch" action="/youtubesearchcontroller" method="post">
			<input type="text" id="array" name="array" value="">
			<input type="submit" id="searchBtn" name="searchBtn" title="search" value="Buscar" onclick="">
			</form>

		<script type="text/javascript">
		
		function seleccionar(id){
			document.getElementById("previo").src = "https://www.youtube.com/embed/"+id+"/>";
			document.getElementById("add").setAttribute('onclick',"add('"+id+"')");
		}
		
		function add(id){
			var table = document.getElementById("seleccionados");
			var i = table.rows.length;
			var row = table.insertRow(i);
			var c0 = row.insertCell(0);
			var c1 = row.insertCell(1);
			var c2 = row.insertCell(2);
			c0.innerHTML = "<img src='https://img.youtube.com/vi/"+id+"/0.jpg' width='50'>";
			c1.innerHTML = "https://www.youtube.com/embed/"+id+"/";
			c2.innerHTML = "<button onclick='remove(this)'>x</button>";
			
		}
		function remove(id){
			document.getElementById("seleccionados").deleteRow(id);
		}
		function table(){
			var recorrer = document.getElementById("seleccionados");
			var i;
			var resultado = "";
			for(i=0; i<recorrer.rows.length; i++){
				resultado = resultado + recorrer.rows[i].cells[1].innerHTML + "\t";
			}
			alert(resultado);
			document.getElementById("array").value = resultado;
		}
		
		</script>
	</fieldset>
</body>
</html>
