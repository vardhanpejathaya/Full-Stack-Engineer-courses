<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Locations</title>
</head>
<body>

<table>

<tr>
	<th>id</th>
	<th>name</th>
	<th>code</th>
	<th>type</th>
	<th>action</th>
</tr>

<c:forEach items="${locations}" var="location">

<tr>
	<td align="center">${location.id}</td>
	<td>${location.name}</td>
	<td>${location.code}</td>
	<td>${location.type}</td>
	<td><a href="deleteLocation?locationid=${location.id}">delete</a></td>
	<td><a href="showUpdate?locationid=${location.id}">edit</a></td>
</tr>

</c:forEach>

<tr>
	<td><a href="showCreateLocation"> Add Locations</a></td>
</tr>

</table>
</body>
</html>