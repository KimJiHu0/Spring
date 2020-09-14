<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegistForm</title>
<script type="text/javascript">

var msg = '${msg}';
if(msg != ''){
	alert(msg);
}

</script>
</head>
<body>
	<h1>RegistForm</h1>
	
	<form action="registres.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid" placeholder="Write ID"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="memberpw" placeholder="Write PW"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername" placeholder="Write NAME"/></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="OK"/>
					<input type="button" value="Cancel" onclick="location.href='login.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>