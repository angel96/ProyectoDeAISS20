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
	style="background-image: url(/images/background.jpeg); background-size: 100%; text-align: center;">
	<p
		style="   text-shadow: 10px 8px #9b9b9b, -10px 12px #ccc, -8px -12px #666, 12px -5px #9b9b9b; font-size: 200px; font-family: 'Atomic Age', cursive; color: #bc0009; margin-top: 300px; margin-bottom: 20px;">SpotyGO</p>
	<h2>
		<p class="message">${message}</p>
	</h2>

	<form id="formSearch" action="tmdbsearchcontroller" method="post">
		<input type="text" name="query" required /> <input type="submit"
			name="searchBtn" title="search" value="BUSCAR">
	</form>

	<footer>
	<table width="">
		<tr>
			<td><a href="/googleDriveListing">Listado de ficheros de
					Google Drive</a></td>
			<td><a href="api/tmdb/all">TMDB - API</a></td>
			<td><a href="api/drive/all">GoogleDrive - API - Ficheros</a></td>
		</tr>
		<tr>
			<td><a href="/developers">Desarrolladores</a></td>

			<td><a href="api/youtube/all">Youtube - API</a></td>

		</tr>


	</table>

	</footer>
</body>
</html>
