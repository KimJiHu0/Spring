<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var msg='${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>

</head>
<body>

	<h1>Detail</h1>
	
	<table border="1">
		<tr>
			<th>WRITER</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>
				<textarea rows="10" cols="60" readonly="readonly">${dto.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>REGDATE</th>
			<td>${dto.regdate }</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="수정" onclick="location.href='updateform.do?seq=${dto.seq}'"/>
				<input type="button" value="삭제" onclick="location.href='delete.do?seq=${dto.seq}'"/>
				<input type="button" value="뒤로" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>

</body>
</html>