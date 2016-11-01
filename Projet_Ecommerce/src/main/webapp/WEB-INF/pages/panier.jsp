<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panier</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/client/index">Accueil</a>


	<div align="center">
		<table align="center" width="80%" cellspacing="0" cellpadding="5">

			<tr>
				<td>
					<table cellspacing="0" cellpadding="6" border="1" width="100%">
						<tr>
							<td colspan="7"
								style="background-color: lightblue; color: darkgreen; font-size: 16pt"
								align="center">Panier</td>
						</tr>
						<tr bgcolor="grey" style="color: white">
							<th>Produit</th>
							<th>Quantit�</th>
							<th>Prix</th>
							<th>Supprimer</th>
						</tr>
						<c:forEach var="lc" items="${panierList}">
							<tr bgcolor="lightyellow">
								<td><b>${lc.produit.nom}</b></td>
								<td>${lc.quantite}</td>
								<td>${lc.prix}</td>
								<td><a href="${pageContext.request.contextPath}/client/retirerPanier/${lc.produit.nom}">Retirer du panier</a></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
	<h3 align="center">Prix total : ${prix} </h1>
	
	<br/><br/>
	<a href="${pageContext.request.contextPath}/client/connexion">Poursuivre la commande</a>


</body>
</html>