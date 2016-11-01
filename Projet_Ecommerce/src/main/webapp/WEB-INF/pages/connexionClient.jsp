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

	<h1 align="center">Se connecter</h1>
	
	<h3 align="center" style="color: red">${message}</h3>

	<form:form method="post" action="connecterClient"
		modelAttribute="client">

		<table style="text-align: center;">
			<tr>
				<td><form:label path="nom">Nom :</form:label></td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Mot de passe :</form:label></td>
				<td><form:input path="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Connexion" /></td>
			</tr>

		</table>
	</form:form>

	<br/><br/>
	<a href="${pageContext.request.contextPath}/client/creerClient">Créer un compte client</a>

</body>
</html>