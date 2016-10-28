<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter une catégorie</title>
</head>
<body>


<body>

<h1 align="center">Ajouter une catégorie</h1>
<form:form method="post" action="insererCategorie" modelAttribute="categorie" >

<table style="text-align: center;">
<tr> Ajouter une catégorie</tr>
<tr>
<td><form:label path="nom">Nom:</form:label></td>
<td><form:input path="nom"/></td>
</tr>

<tr>
<td>
<input type="submit" value="Ajouter"/>
</td>
</tr>

</table>
</form:form>

</body>
</html>