<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un Produit</title>
</head>
<body>

	<h1 align="center">Ajouter un Produit</h1>
	<form:form method="post" action="insererProduit"
		modelAttribute="produit">

		<table style="text-align: center;">
			<tr>Ajouter un Produit
			</tr>
			<tr>
				<td><form:input type="hidden" path="id_produit" /></td>
			</tr>
			<tr>
				<td><form:label path="nom">Nom:</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><form:label path="prix">Prix:</form:label></td>
				<td><form:input path="prix" /></td>
			</tr>
			<tr>
				<td><form:label path="quantite">Quantite:</form:label></td>
				<td><form:input path="quantite" /></td>
			</tr>
			<tr>
				<td><form:label path="categorie.id_categorie">Categorie:</form:label></td>
				<td><form:input path="categorie.id_categorie" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Ajouter" /></td>
			</tr>

		</table>
	</form:form>
	
	
	<a href="${pageContext.request.contextPath}/gestion/index">Retour</a>

</body>
</html>