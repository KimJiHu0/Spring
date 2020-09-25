<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>InsertForm</h1>
	
	<form action="insertres.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<th>KOR</th>
				<td><input type="text" name="kor"/></td>
			</tr>
			<tr>
				<th>ENG</th>
				<td><input type="text" name="eng"/></td>
			</tr>
			<tr>
				<th>MATH</th>
				<td><input type="text" name="math"/></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="작성완료"/>
					<input type="button" value="뒤로가기" onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>