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
	<input type="hidden" name="myno" value="${dto.myno }"/>
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
				<td>${dto.mydate }</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="수정완료"/>
					<input type="button" value="뒤로가기" onclick="location.href='detail.do?myno=${dto.myno}'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>