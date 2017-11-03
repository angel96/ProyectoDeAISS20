<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>SpotyGo</title>
</head>

<body style="background-image:url(/images/background.jpeg); background-size: 100%; 	text-align: center;">
	<h1>SPOTYGO</h1>
	<h2>
		<p class="message">${message}</p>
	</h2>

				<form id="formSearch" action="tmdbsearchcontroller" method="post">
					<input type="text" name="query" required />
					<input type="submit"
						name="searchBtn" title="search" value="BUSCAR">
				</form>
				
<jsp:include page="footer.jsp" />
</body>
</html>
