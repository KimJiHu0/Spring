<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist</title>
<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>
</head>
<body>
	<h1>Regist</h1>
	
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
				<td colspan="4">
					<input type="submit" value="OK"/>
					<input type="button" value="CANCEL" onclick="location.href='loginform.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>