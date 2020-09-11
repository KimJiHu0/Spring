<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegistForm</title>
</head>
<body>
	<h1>RegistForm</h1>
	<form action="registres.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="memberpw"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername"/></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="OK"/>
					<input type="button" value="Cancel" onclick="location.href='loginform.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>