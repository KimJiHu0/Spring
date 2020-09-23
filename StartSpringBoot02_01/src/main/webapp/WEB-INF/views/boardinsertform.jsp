<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insertForm</h1>
	
	<form action="insertres" method="post">
		<table>
			<tr>
				<th>NAME</th>
				<td>
					<input type="text" name="myname"/>
				</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td>
					<input type="text" name="mytitle"/>
				</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea rows="10" cols="60" name="mycontent"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="작성"/>
					<input type="button" value="뒤로" onclick="location.href='list'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>