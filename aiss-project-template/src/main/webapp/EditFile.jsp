<%@include file="includes/header.jsp"%>

<% String controller = "GoogleDriveFileNew"; %>
	
	<c:if test="${not empty file}">
    	<% controller = "GoogleDriveFileUpdate"; %>
	</c:if>

	<div class="container">
	
		<p class="message">${message}</p>
				
		<form action="<%= controller %>" method="post">
			<c:if test="${not empty file}">
				<input type="hidden" name="id" value="${file.id}">
			</c:if>
			File name: <input type="text" name="title" 
							<c:if test="${not empty file}">
								disabled="true" 
								value="${file.title}"
								</c:if>
								><br>
			Content: <textarea name="content"><c:forEach
					items="${requestScope.array}" var="x">
					${x}
			</c:forEach></textarea>
			<br>
			<div class="bottom_links">
				<button type="submit" class="button">Submit</button>
				<button type="button" onClick="javascript:window.location.href='index.jsp'" class="button">Cancel</button>
			</div>
		</form>
	</div>

<%@include file="includes/footer.jsp"%>
