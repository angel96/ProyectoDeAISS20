<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Atomic+Age"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>SpotyGo</title>
</head>

<body
	style="background-image: url(/images/background.jpeg); background-repeat: no-repeat; background-size: 100%; background-position: center; background-color: black; text-align: center;">

	<p class="appTitle">SpotyGO</p>
	<h2 class="message">${message}</h2>

	<form id="formSearch" action="tmdbsearchcontroller" method="post">
		<input type="text" name="query" required /> <input type="submit"
			name="searchBtn" title="search" value="BUSCAR">
	</form>
	<a href="/GoogleDriveFileListing.jsp">Edita tus archivos de Google
		Drive accediendo a este enlace</a>


	<script>
		if (typeof (Storage) !== "undefined") {
			sessionStorage.setItem("on", 0);
		} else {
			alert("Sin almacenamiento local");
		}
	</script>
</body>
</html>
