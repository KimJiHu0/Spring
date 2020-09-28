<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>

<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>

</head>
<body>

	<h1>Detail</h1>
	
	<table>
		<tr>
			<th>작성자</th>
			<td>${dto.boardname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.boardtitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="60">${dto.boardcontent }</textarea>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.boarddate }</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="뒤로" onclick="location.href='list.do'"/>
				<input type="button" value="수정" onclick="location.href='updateform.do?boardno=${dto.boardno}'"/>
				<input type="button" value="삭제" onclick="location.href='delete.do?boardno=${dto.boardno}'"/>
			</td>
		</tr>
	</table>

</body>
</html>