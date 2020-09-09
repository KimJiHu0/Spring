<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DetailList</title>
<style type="text/css">
h1 {
	background-color: black;
	color: white;
	text-align: center;
	border-collapse: collapse;
}
textarea{
	resize : none;
}
</style>
</head>
<body>
	<h1>DetailList</h1>
	
	<table border="1">
		<tr>
			<th>NAME</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>
				<textarea rows="10" cols="60" readonly="readonly">${dto.mycontent }</textarea>
			</td>
		</tr>
		<tr>
			<th>DATE</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.mydate }"/></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<button onclick="location.href='updateform.do?myno=${dto.myno}'">수정</button>
				<button onclick="location.href='delete.do?myno=${dto.myno}'">삭제</button>
				<button onclick="location.href='list.do'">뒤로가기</button>
			</td>
		</tr>
	</table>
</body>
</html>