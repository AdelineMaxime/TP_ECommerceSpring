<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter une cat�gorie</title>
</head>
<body>
<body>

	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">Ajouter une cat�gorie</h1>
	</div>

	<form:form method="post" action="insererCategorie"
		modelAttribute="categorie">

		<table align = "center">
			<tr>
				<td><form:label path="nom">Nom de la cat�gorie :</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Ajouter" /></td>
			</tr>

		</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/gestion/index" >Retour �
		l'accueil Gestionnaire</a>

</body>
</html>