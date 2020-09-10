<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateForm</title>
<style type="text/css">
	textarea{
		resize : none;
	}
</style>
</head>
<body>
	<h1>Update</h1>
	
	<form action="updateres.do" method="post">
		<table>
			<tr>
				<th>NAME</th>
				<td>${dto.myname }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="mytitle" value="${dto.mytitle }"/></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea rows="10" cols="60" name="mycontent">${dto.mycontent }</textarea>
				</td>
			</tr>
			<tr>
				<th>DATE</th>
				<td></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수정완료"/>
					<input type="button" value="뒤로가기" onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>