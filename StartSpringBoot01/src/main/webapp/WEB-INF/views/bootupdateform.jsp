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

	<h1>UpdateForm</h1>
	
	<form action="updateres" method="post">
	<input type="hidden" name="myno" value="${dto.myno }"/>
		<table>
			<tr>
				<th>NAME</th>
				<td>${dto.myname }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td>
					<input type="text" name="mytitle" value="${dto.mytitle }"/>
				</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea rows="10" cols="60" name="mycontent">${dto.mycontent }</textarea>
				</td>
			</tr>
			<tr>
				<th>DATE</th>
				<td><fmt:formatDate pattern="yyyy-MM-d" value="${dto.mydate }"/></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="수정완료"/>
					<input type="button" value="뒤로가기" onclick="location.href='detail?myno=${dto.myno}'"/>
				</td>
			</tr>
		</table>
	</form>
	

</body>
</html>