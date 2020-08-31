<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Get</h1>
	
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>ADDR</th>
			<th>PHONE</th>
		</tr>
		<tr>
			<td>${dto.name }</td>
			<td>${dto.addr }</td>
			<td>${dto.phone }</td>
		</tr>
	</table>

</body>
</html>