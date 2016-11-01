<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Produits par Catégorie</title>
</head>
<body>

	<div align="center">
		<table align="center" width="80%" cellspacing="0" cellpadding="5">

			<tr>
				<td>
					<table cellspacing="0" cellpadding="6" border="1" width="100%">
						<tr>
							<td colspan="7"
								style="background-color: lightblue; color: darkgreen; font-size: 16pt"
								align="center">Liste Des Produits de ${categorie.nom}, d'ID
								${categorie.id_categorie}</td>
						</tr>
						<tr bgcolor="grey" style="color: white">
							<th>No</th>
							<th>Nom</th>
							<th>Description</th>
							<th>Prix</th>
							<th>Quantité</th>
							<th>Action sur les Produits</th>
						</tr>
						<c:forEach var="produit" items="${listeProdCat}">
							<tr bgcolor="lightyellow">
								<td align="center"><b>${produit.id_produit}</b></td>
								<td align="center">${produit.nom}</td>
								<td align="center">${produit.description}</td>
								<td align="center">${produit.prix}</td>
								<td align="center">${produit.quantite}</td>
								<td align="center"><a
									href="${pageContext.request.contextPath}/gestion/editProduit/${produit.nom}">
										Modifier le produit</a> // <a
									href="${pageContext.request.contextPath}/gestion/supprimerProd/${produit.nom}">
										Supprimer le produit </a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<a href="${pageContext.request.contextPath}/gestion/addProd">
		Ajouter un produit</a>

	<br />

	<a href="${pageContext.request.contextPath}/gestion/index">
		Retourner à l'accueil du Gestionnaire</a>

</body>
</html>