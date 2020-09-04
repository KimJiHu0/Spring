<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<style type="text/css">
	textarea{
		resize : none;
	}
</style>
</head>
<body>
	<h1>글 상세보기</h1>

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
			<td></td>
		</tr>
		<tr>
			<td colspan="4" aling="right">
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'"/>
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'"/>
				<input type="button" value="뒤로" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>