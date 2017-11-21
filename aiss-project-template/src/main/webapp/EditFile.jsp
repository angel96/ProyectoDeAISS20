<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String controller = "GoogleDriveFileNew";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Posting to Google Drive</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>

<c:if test="${not empty file}">
	<%
		controller = "GoogleDriveFileUpdate";
	%>
</c:if>

<div class="container">
	<p class="message">${message}</p>

	<form action="<%=controller%>" method="post">
		<c:if test="${not empty file}">
			<input type="hidden" name="id" value="${file.id}">
		</c:if>
		File name: <input type="text" name="title"
			<c:if test="${not empty file}">
								disabled="true" 
								value="${file.title}"
								</c:if>><br>
		
		<script type="text/javascript">
		
		var res = [];
		
		function sacarElementos(){
			var api = "AIzaSyA8D5TT3FHvNuwsjn1hyYBolekLcpjCr8k";
			var elements = ["lWh1TKGmGJk", "SGEZti66WJs"];
			var q;
			
			for(i = 0; i< elements.length; i++){
				var x = elements[i];
				q = "https://www.googleapis.com/youtube/v3/videos?id=" + x + "&key=" + api + "&fields=items(snippet(title))&part=snippet";	
				$.ajax({
					type: "GET",
					url: q,
					dataType: 'json',
					success:function(data){
						res.push(data.items[0].snippet.title);
					},
					error: function(jqXHR, textStatus, errorThrown){
						return textStatus, + ' | ' + errorThrown;
					}
				});
			}
			return res;
		}
		</script>

		Content:
		<textarea name = "content"></textarea>
		
		<div class="bottom_links">
			<button type="submit" class="button">Submit</button>
			<button type="button"
				onClick="javascript:window.location.href='index.jsp'" class="button">Cancel</button>
		</div>

	</form>
</div>
</body>
</html>
