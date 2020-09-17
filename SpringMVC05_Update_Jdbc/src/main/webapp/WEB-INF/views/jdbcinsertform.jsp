<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

var msg = '${msg}';
if( msg != ''){
	alert(msg);
}

</script>

</head>
<body>

	<h1>Insert</h1>

<form action="insertres.do" method="post">
	<table border="1">
		<tr>
			<th>WRITER</th>
			<td>
				<input type="text" name="writer"/>
			</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td>
				<input type="text" name="title"/>
			</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>
				<textarea rows="10" cols="60" name="content"></textarea>
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