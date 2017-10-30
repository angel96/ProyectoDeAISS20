<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> 
 <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

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
					<img class="img" src="https://i.ytimg.com/vi/${x.id.videoId}/movieposter.jpg" width="260"  
					onclick="seleccionar('${x.id.videoId}')">
					<%-- <a>${x.snippet.title}</a>
					<a>ADD</a> --%>

				</c:forEach>
		</div>
	</fieldset>
	<fieldset>
			<label>Seleccionados</label>
			<table id="seleccionados">
			<c:forEach items="${requestScope.ids}" var="y">
			<tr>
			<td><img src='https://img.youtube.com/vi/${y}/0.jpg' width='50'></td>
			<td>https://www.youtube.com/embed/${y}/</td>
			<td><button onclick='remove(this)'>x</button></td>
			<td style="display:none">${y}</td>
			</tr>	
			</c:forEach>
			</table>
	</fieldset>
			
			<!-- Volver a TMDBResults -->
			<form id="return" action="/tmdbsearchcontroller" method="post">
			<!--Búsqueda realizada desde TMDB-->
			<input type="hidden" id="selected" name="selected" value="${requestScope.array}">
			<!--Devuelve las ID de los videos seleccionados-->
			<input type="hidden" id="ids" name="ids" value="<c:forEach items="${requestScope.ids}" var="y">${y}#</c:forEach>">
			<input type="submit" id="return" name="return" title="return" value="Volver" onclick="">
			</form>
			
			<!--Enviar a Google Drive-->
			
			Enviar a Google Drive
			<form id="formSearch" action="/DriveFilePostController" method="post">
			<input type="hidden" id="array" name="array" value="">
			<input type="submit" id="searchBtn" name="searchBtn" title="search" value="Guardar" onclick="">
			</form>

		<script type="text/javascript">
		
		function seleccionar(id){
			document.getElementById("previo").src = "https://www.youtube.com/embed/"+id+"/>";
			document.getElementById("add").setAttribute('onclick',"act('"+id+"')");
			
		}
		
		function add(id){
			var table = document.getElementById("seleccionados");
			var i = table.rows.length;
			var row = table.insertRow(i);
			var c0 = row.insertCell(0);
			var c1 = row.insertCell(1);
			var c2 = row.insertCell(2);
			var c3 = row.insertCell(3);
			c0.innerHTML = "<img src='https://img.youtube.com/vi/"+id+"/0.jpg' width='50'>";
			c1.innerHTML = "https://www.youtube.com/embed/"+id+"/";
			c2.innerHTML = "<button onclick='remove(this)'>x</button>";
			c3.innerHTML = id;
			table.rows[i].cells[3].style.display = "none";
			
		}
		function act(id){
			add(id)
			table();
		}
		function remove(id){
			document.getElementById("seleccionados").deleteRow(id);
			table();
		}
		function table(){
			var recorrer = document.getElementById("seleccionados");
			var i;
			var resultado = "";
			var ids = "";
			for(i=0; i<recorrer.rows.length; i++){
				resultado = resultado + recorrer.rows[i].cells[1].innerHTML + "\t";
				ids = ids + recorrer.rows[i].cells[3].innerHTML + "#";
			}
			document.getElementById("array").value = resultado;
			document.getElementById("ids").value = ids;
		}
		
		
		</script>

</body>
</html>
