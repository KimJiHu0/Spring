<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>RegistForm</h1>
	
	<form action="registres.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="memberid"/>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="text" name="memberpw"/>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="membername"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Ok"/>
					<input type="button" value="Back" onclick="location.href='loginform.do'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>