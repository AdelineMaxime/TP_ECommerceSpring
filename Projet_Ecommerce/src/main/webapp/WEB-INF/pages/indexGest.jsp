<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Insert title here</title>
</head>


<body>

	<a href="${pageContext.request.contextPath}/gestion/addCat"
		style="background-color: lightblue;"> Ajouter une categorie </a> ${title}

	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">Liste
			des Catégories</h1>
	</div>


	<div align="center">
		<table cellspacing="0" cellpadding="6" border="1" width="100%">
			<tr>
				<td colspan="7"
					style="background-color: lightblue; color: darkgreen; font-size: 16pt"
					align="center">Liste Des Categories</td>
			</tr>
			<tr bgcolor="grey" style="color: white">

				<th>No</th>
				<th>Nom</th>
			</tr>
			<c:forEach var="categorie" items="${listCategorie}">
				<tr bgcolor="lightyellow">
					<td align="center"><b>${categorie.id_categorie}</b></td>
					<td align="center">${categorie.nom}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>