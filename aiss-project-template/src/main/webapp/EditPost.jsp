<%@include file="includes/header.jsp"%>
	<h1>Publicar Post en Facebook</h1>
	<div class="container">
	
		<p class="message"></p>
				
		<form action="/facebookPostCreation" method="post">
			
			Mensaje: <textarea name="message"></textarea>
			<br>
			<div class="bottom_links">
				<button type="submit" class="button">Publicar en Facebook</button>
				<button type="button" onClick="javascript:window.location.href='index.html'" class="button">Cancel</button>
			</div>
		</form>
	</div>

<%@include file="includes/footer.jsp"%>
