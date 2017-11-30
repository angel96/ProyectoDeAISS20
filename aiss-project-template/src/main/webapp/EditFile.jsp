<%@include file="includes/header.jsp"%>
<%
	String controller = "GoogleDriveFileNew";
%>
<c:if test="${not empty file}">
	<%
		controller = "GoogleDriveFileUpdate";
	%>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body style="background-color: #000; color: #5a5a5a">
<nav id="navbar" style="border-bottom: 2px solid #bc0009">

		<button type="button" id="return"
			onClick="javascript:window.location.href='index.jsp'" class="button">CANCELAR</button>
	</nav>
	<div class="container" style="margin-top: 80px; background-color: #fff; color: #000; padding:50px">

		<p class="message">${message}</p>

		<form action="<%=controller%>" method="post">
			<c:if test="${not empty file}">
				<input type="hidden" name="id" value="${file.id}">
			</c:if>
			<b>Nombre del documento:</b> <input type="text" placeholder="Documento sin título" name="title"
				required
				<c:if test="${not empty file}">
								disabled="true" 
								value="${file.title}"
								</c:if>>
			<input type="hidden" id="textcontent" name="content"> 
			<br><br>
			<p>Seleccione el campo de la tabla que quiere modificar. Para
				insertar nuevas filas en la tabla seleccione (+).</p>
			<br>
			<table class="table">
				<tr>
					<thread>
					<th>ID</th>
					<th>Título</th>
					<th>Enlace al vídeo</th>
					<th>Póster de la película</th>
					</thread>
				</tr>
				<c:forEach items="${requestScope.array}" var="x">
					<tr contenteditable="true">
						<td scope="row">${x.id.videoId}</td>
						<td>${x.snippet.title}</td>
						<td>https://www.youtube.com/embed/${x.id.videoId}/</td>
						<td>https://i.ytimg.com/vi/${x.id.videoId}/movieposter.jpg</td>
					</tr>
				</c:forEach>
			</table>
			
			<input type="hidden" id="texto" value="${content}">
			<button class="button" onclick="tableToText()">GUARDAR EN
				GOOGLE DRIVE</button>
		</form>
		
		<button onclick="addRow()">AÑADIR FILA</button>

		<script>
			function tableToText() {
				var i, text;
				text = "";
				var info = document.getElementsByTagName("td");

				var a = new Array();
				for (i = 0; i < info.length; i++) {
					if (info[i]) {
						a.push(info[i]);
					}

				}
				info = a;

				for (i = 0; i < info.length; i += 4) {
					text += info[i].innerText + "-#" + info[i + 1].innerText
							+ "-#" + info[i + 2].innerText + "-#"
							+ info[i + 3].innerText + "-#";
				}
				document.getElementById("textcontent").value = text;

			}
			window.onload = function textToTable() {
				var table = document.getElementsByTagName("table")[0];
				var info = document.getElementById("texto").value.split("-#");

				var a = new Array();
				for (i = 0; i < info.length; i++) {
					if (info[i] && info[i]!=="\n") {
						a.push(info[i]);
					}

				}
				info = a;

				for (i = 0; i < info.length; i += 4) {
					var row = table.insertRow(table.length);
					row.setAttribute("contenteditable", "true");
					var c0 = row.insertCell(0);
					var c1 = row.insertCell(1);
					var c2 = row.insertCell(2);
					var c3 = row.insertCell(3);
					c0.innerHTML = info[i];
					c1.innerHTML = info[i + 1];
					c2.innerHTML = info[i + 2];
					c3.innerHTML = info[i + 3];
				}
			}

			function addRow() {
				var table = document.getElementsByTagName("table")[0];
				var row = table.insertRow(table.length);
				row.setAttribute("contenteditable", "true");
				var c0 = row.insertCell(0);
				var c1 = row.insertCell(1);
				var c2 = row.insertCell(2);
				var c3 = row.insertCell(3);
				c0.innerHTML = "Añadir ID";
				c1.innerHTML = "Añadir Título";
				c2.innerHTML = "Añadir Enlace";
				c3.innerHTML = "Añadir Póster";

			}
		</script>

	</div>

	<%@include file="includes/footer.jsp"%>


</body>

</html>
