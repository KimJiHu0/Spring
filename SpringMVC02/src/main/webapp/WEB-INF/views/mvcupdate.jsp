<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정하기</h1>
	<form action="updateres.do" method="post">
	<input type="hidden" name="myno" value="${dto.myno }"/>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" value="${dto.mytitle }" name="mytitle"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="60" name="mycontent">${dto.mycontent }</textarea></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.mydate}"/></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="submit" value="수정"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>