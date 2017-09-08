<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda TMDB</title>
</head>
<body>
  <!--RESULTADOS DE TMDB: SE MUESTRAN LOS RESULTADOS DE LA BÚSQUEDA-->
	<fieldset id="TMDB">
		<legend>
			TMDB search for
			<c:out value="${param.query}" />
		</legend>
		<div class="seleccionar">
			<label>Seleccionar</label> <select id="select1" name="select1"
				size="10" tabindex="1">
				<option value=""></option>
				<c:forEach items="${requestScope.results}" var="x">
					<option><c:out value="${x.title}" /></option>
				</c:forEach>
			</select> <a href="#" id="add"> A�adir a seleccionados</a>
		</div>
<!--RESULTADOS DE TMDB: SE MUESTRAN LOS SELECCIONADOS-->
		<div class="seleccionados">
			<label>Seleccionados</label> <select id="select2" size="3"
				tabindex="1"></select> <a href="#" id="remove">Quitar seleccion</a>
		</div>
		<script type="text/javascript">
			$("#add").click(function() {
				$("#select1 option:selected").remove().appendTo($("#select2"));
			});
			$("#remove").click(function() {
				$("#select2 option:selected").remove().appendTo($("#select1"));
			});
		</script>
	</fieldset>
</body>
</html>
