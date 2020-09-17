<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Update</h1>
	
	<form action="updateres.do" method="post">
	<input type="hidden" name="seq" value="${dto.seq }"/>
		<table>
			<tr>
				<th>WRITER</th>
				<td>${dto.writer }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" value="${dto.title }"/></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea rows="10" cols="60" name="content">${dto.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>REGDATE</th>
				<td>${dto.regdate }</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="수정완료"/>
					<input type="button" value="취소하기" onclick="location.href='detail.do?seq=${dto.seq}'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>