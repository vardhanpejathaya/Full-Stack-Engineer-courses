<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location Information</title>
</head>
<body>

	<form action="updateLoc" method="post">

		<table>
			<tr>
				<td>ID: <input type="text" name="id" value="${location.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Name: <input type="text" name="name" value="${location.name}"></td>
			</tr>
			<tr>
				<td>Code: <input type="text" name="code" value="${location.code}"></td>
			</tr>
			<tr>
				<td>Type</td>

			</tr>
			<tr>
				<td>Urban: <input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':'' }> Rural: <input
					type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':'' }></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
	
	<a href="getAllLocations">View All Locations</a>
</body>
</html>