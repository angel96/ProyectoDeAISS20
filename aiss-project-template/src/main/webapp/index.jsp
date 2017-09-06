<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>SpotyGo</title>
</head>

<body>
	<h1>SpotyGo</h1>
	<h2>
		<p class="message">${message}</p>
	</h2>
	<table>
		<tr>
			<td colspan="2" style="font-weight: bold;">Available Servlets:</td>
		</tr>
		<tr>
			<div id="search">
				<form id="formSearch" action="searchcontroller" method="post">
					<input type="text" name="query" required /> <input type="submit"
						name="searchBtn" title="search" value="search">
				</form>
			</div>
		</tr>
		<tr>
			<td><a href="/googleDriveListing">Listado de ficheros de
					Google Drive</a></td>
		</tr>
		<tr>
			<td><a href="/developers">Desarrolladores</a></td>
		</tr>
	</table>
</body>
</html>
