<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성하기</title>
<style type="text/css">
h1 {
	background-color: black;
	color: white;
	text-align: center;
	border-collapse: collapse;
}
textarea{
	resize : none;
}
</style>
</head>
<body>
	<h1>insertList</h1>
	<form action="insertres.do" method="post">
	<table border="1">
		<tr>
			<th>NAME</th>
			<td>
				<input type="text" name="myname" placeholder="작성자를 입력해주세요."/>
			</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td>
				<input type="text" name="mytitle" placeholder="제목을 입력해주세요."/>
			</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>
				<textarea rows="10" cols="60" name="mycontent" placeholder="내용을 입력해주세요."></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="submit" value="작성완료"/>
				<input type="button" value="돌아가기" onclick="location.href='list.do'"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>