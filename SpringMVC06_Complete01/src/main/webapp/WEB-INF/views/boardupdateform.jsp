<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateForm</title>

<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>

</head>
<body>

	<h1>UpdateForm</h1>
	<form action="updateres.do" method="post">
	<input type="hidden" name="boardno" value="${dto.boardno }"/>
		<table>
			<tr>
				<th>이름</th>
				<td>${dto.boardname }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="boardtitle" value="${dto.boardtitle }"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" name="boardcontent">${dto.boardcontent }</textarea>
				</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.boarddate }</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정"/>
					<input type="button" value="취소" onclick="location.href='detail.do?boardno=${dto.boardno}'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>