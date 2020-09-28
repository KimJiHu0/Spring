<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>
</head>
<body>

	<h1>Insert</h1>
	
	<form action="insertres.do" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="boardname"/>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="boardtitle"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="60" name="boardcontent"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="작성"/>
					<input type="button" value="뒤로" onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>