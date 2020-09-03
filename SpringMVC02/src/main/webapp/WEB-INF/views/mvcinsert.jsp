<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 작성하기</h1>
	<!-- 내가 입력할 값을을 한번에 보내기 위해 form태그를 사용했고 -->
	<!-- 보내줄 경로는 insertres.do라는 곳으로 보내줄거다. -->
	<!-- 작성을 다 한 후에는 submit이벤트가 발생하여 name들을 전부 insertres.do로 보내준다. -->
	<form action = "insertres.do" method="post">
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="myname" placeholder="작성자를 입력해주세요."/>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="mytitle" placeholder="제목을 입력해주세요."/>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="60" name="mycontent" placeholder="내용을 입력해주세요."></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align = "right">
				<input type="submit" value="작성"/>
				
			</td>
		</tr>
	</table>
	</form>
</body>
</html>