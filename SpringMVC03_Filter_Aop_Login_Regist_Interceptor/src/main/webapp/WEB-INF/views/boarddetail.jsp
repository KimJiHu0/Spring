<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<h1>Detail</h1>
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
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'"/>
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'"/>
				<input type="button" value="뒤로" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>