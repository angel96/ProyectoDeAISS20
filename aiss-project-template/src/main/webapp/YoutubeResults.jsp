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
		<legend>
			Youtube search for
			<c:out value="${param.query}" />
		</legend>
		<c:forEach items="${requestScope.videos}" var="x">
			<table>
				<tr>
					<td><iframe width="260" height="115"
							src="https://www.youtube.com/embed/${x	}/>"
							frameborder="0" allowfullscreen></iframe></td>
				</tr>
			</table>
		</c:forEach>
	</fieldset>
</body>
</html>
