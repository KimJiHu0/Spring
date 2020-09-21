<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>

<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>

</head>
<body>
	<h1>selectOne</h1>
	
	<table>
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
			<td>${dto.mydate }</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'"/>
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'"/>
				<input type="button" value="뒤로" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>