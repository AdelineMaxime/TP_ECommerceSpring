<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<div align="center">
		<h1 style="background-color: lightgreen; color: darkgreen">Identification du Gestionnaire </h1>
	</div>

	<form action="j_spring_security_check" method="post">

		<table align="center">
			<tr>
				<td>Login</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Se connecter" /></td>
			</tr>

		</table>

	</form>
	<a href="${pageContext.request.contextPath}"> Retourner à l'écran
		d'accueil </a>

</body>
</html>