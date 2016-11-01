<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page accueil Gestionnaire</title>
</head>
<body>

	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">${title}</h1>
	</div>
	<br />
	<a href="${pageContext.request.contextPath}/gestion/addCat"
		style="background-color: lightblue;"> Ajouter une categorie </a>
	<br />

	<a href="${pageContext.request.contextPath}/gestion/addProd">
		Ajouter un produit</a>

	<br />


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
				<th>Produits associés</th>
				<th>Action sur la Catégorie</th>
			</tr>
			<c:forEach var="categorie" items="${listCategorie}">
				<tr bgcolor="lightyellow">
					<td align="center"><b>${categorie.id_categorie}</b></td>
					<td align="center">${categorie.nom}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/gestion/listeProd/${categorie.id_categorie}">Voir
							les produits</a></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/gestion/supprimerCat/${categorie.nom}">
							Supprimer la categorie </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />
	<a href="<c:url value="/j_spring_security_logout" />">Se
		deconnecter</a>
	<br />

</body>
</html>