<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Créer un compte client</h1>
	
	<p align="center" style="color: red">${message}</p>
	
	<form:form method="post" action="addClient"
		modelAttribute="client">

		<table style="text-align: center;">
			<tr>Informations client
			</tr>
			<tr>
				<td><form:input type="hidden" path="id_client" /></td>
			</tr>
			<tr>
				<td><form:label path="nom">Nom :</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="adresse">Adresse :</form:label></td>
				<td><form:input path="adresse" /></td>
			</tr>
			<tr>
				<td><form:label path="mail">Mail :</form:label></td>
				<td><form:input path="mail" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Mot de passe :</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="tel">Telephone :</form:label></td>
				<td><form:input path="tel" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Ajouter" /></td>
			</tr>

		</table>
	</form:form>


</body>
</html>