<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> -->
  <!-- <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda TMDB</title>
</head>
<body>
  <!--TODO recorrer todos los elementos seleccionados de la lista de TMBD-->
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

	<!--RESULTADOS DE TMDB: SE MUESTRAN LOS RESULTADOS DE LA BÚSQUEDA-->
	<fieldset id="TMDB">
		<div class="seleccionados">
			<label>Seleccionados</label>
			<table id="#select2"></table>
			<form id="formSearch" action="/youtubesearchcontroller" method="post">
			<input type="text" id="array" name="array" value="">
			<input type="submit" id="searchBtn" name="searchBtn" title="search" value="Buscar" onclick="">
			</form>
			<button id="mostrar">Confirmar</button>
		</div>
	
		
		<script type="text/javascript">
		
		function seleccionar(id){
			document.getElementById("previo").src = "https://www.youtube.com/embed/"+id+"/>";
			document.getElementById("add").setAttribute('onclick',"add('"+id+"')");
		}
		
		function add(id){
			var table = document.getElementById("#select2");
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
			document.getElementById("#select2").deleteRow(id);
		}
		
		
		</script>
	

		<script type="text/javascript">
	
			$("#remove").click(function() {
				$("#select2 option:selected").remove().appendTo($("#select1"));
				$("#mostrar").show();
				$("#searchBtn").hide();
			});
			$("#searchBtn").hide();
			$("#mostrar").click(function(){
				$("#array").val("");
				$("#select2 option").each(function(){
				$("#array").val($("#array").val()+($(this).attr('value'))+'#');
			  });
				$("#searchBtn").show();
				$("#mostrar").hide();
				})
		</script>
	</fieldset>
</body>
</html>
