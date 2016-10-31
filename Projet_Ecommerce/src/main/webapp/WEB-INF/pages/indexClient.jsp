<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">${title}</h1>
	</div>

	<a href="${pageContext.request.contextPath}/client/panier">Aller au panier</a>

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
			</tr>
			<c:forEach var="categorie" items="${categorieList}">
				<tr bgcolor="lightyellow">
					<td align="center"><b>${categorie.id_categorie}</b></td>
					<td align="center">${categorie.nom}</td>
					<td><a
						href="${pageContext.request.contextPath}/client/listeProd/${categorie.id_categorie}">Voir
							les produits</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<div align="center">
		<table align="center" width="80%" cellspacing="0" cellpadding="5">

			<tr>
				<td>
					<table cellspacing="0" cellpadding="6" border="1" width="100%">
						<tr>
							<td colspan="7"
								style="background-color: lightblue; color: darkgreen; font-size: 16pt"
								align="center">Liste Des Produits</td>
						</tr>
						<tr bgcolor="grey" style="color: white">
							<th>No</th>
							<th>Nom</th>
							<th>Description</th>
							<th>Prix</th>
							<th>Quantité</th>
							<th>Catégorie</th>
							<th>Acheter</th>
						</tr>
						<c:forEach var="produit" items="${produitList}">
							<tr bgcolor="lightyellow">
								<td><b>${produit.id_produit}</b></td>
								<td>${produit.nom}</td>
								<td>${produit.description}</td>
								<td>${produit.prix}</td>
								<td>${produit.quantite}</td>
								<td>${produit.categorie.nom}</td>
								<td><a
									href="${pageContext.request.contextPath}/client/addPanier/${produit.nom}">Ajouter
										au panier</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<a href="${pageContext.request.contextPath}/gestion/index">Espace
		gestionnaire</a>
</body>
</html>