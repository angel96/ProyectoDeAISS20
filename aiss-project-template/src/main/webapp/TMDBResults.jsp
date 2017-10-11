<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busqueda TMDB</title>
</head>
<body>
  <!--RESULTADOS DE TMDB: SE MUESTRAN LOS RESULTADOS DE LA BÚSQUEDA-->
  <div id="search">
				<form id="formSearch" action="tmdbsearchcontroller" method="post">
					<input type="text" name="selected" placeholder="búsquedas anteriores">
					<input type="text" name="query" placeholder="Buscar películas" required /> 
					<input type="submit" name="searchTMDBbtn" title="search" value="Buscar">
				</form>
			</div>
	<fieldset id="TMDB">
		<legend>
			TMDB search for
			<c:out value="${param.query}" />
		</legend>
		<div class="seleccionar">
			<label>Seleccionar</label> <select id="select1" name="select1"
				size="10" tabindex="1"multiple>
				<option value=""></option>
				<c:forEach items="${requestScope.results}" var="x">
					<option><c:out value="${x.title}" /></option>
				</c:forEach>
			</select> <a href="#" id="add"> Añadir a seleccionados</a>
		</div>
<!--RESULTADOS DE TMDB: SE MUESTRAN LOS SELECCIONADOS-->
		<div class="seleccionados">
			<label>Seleccionados</label>
			<select id="select2" name="select2" size="3" tabindex="1" multiple>
			<c:forEach items="${requestScope.before}" var="y">
					<option value="${y}">${y}</option>
				</c:forEach>
			</select> 
			<a href="#" id="remove">Quitar seleccion</a>
			<form id="formSearchYoutube" action="/youtubesearchcontroller" method="post">
			<input type="text" id="array" name="array" value="">
			<input type="submit" id="searchBtn" name="searchBtn" title="search" value="Buscar" onclick="">
			</form>
			<button id="mostrar">Confirmar</button>
		</div>
		<!-- PRUEBA -->
		
	<!-- FIN PRUEBA -->
		<script type="text/javascript">
			$("#add").click(function() {
				$("#select1 option:selected").remove().appendTo($("#select2"));
				$("#mostrar").show();
				$("#searchBtn").hide();
			});
			$("#remove").click(function() {
				$("#select2 option:selected").remove().appendTo($("#select1"));
				$("#mostrar").show();
				$("#searchBtn").hide();
			});
			$("#searchBtn").hide();
			$("#mostrar").click(function(){
				$("#array").val("");
				$("#select2 option").each(function(){
				$("#array").val($("#array").val()+$(this).attr('value')+'#');
			  });
				$("#searchBtn").show();
				$("#mostrar").hide();
				});
			
			
			
			  
		</script>
	</fieldset>
</body>
</html>
