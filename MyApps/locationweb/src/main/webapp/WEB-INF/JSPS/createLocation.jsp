<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location Information</title>
</head>
<body>

	<form action="saveLoc" method="post">

		<table>
			<tr>
				<td>ID: <input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Name: <input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Code: <input type="text" name="code"></td>
			</tr>
			<tr>
				<td>Type</td>

			</tr>
			<tr>
				<td>Urban: <input type="radio" name="type" value="URBAN"> Rural: <input
					type="radio" name="type" value="RURAL"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
	<h1>${msg}</h1>
	
	<a href="getAllLocations">View All Locations</a>
</body>
</html>