<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<style type="text/css">
	h1{
		background-color : black;
		color : white;
		text-align : center;
	}
</style>
</head>
<body>

	<h1>SpringMVC03_02</h1>
	
	HOME : <button onclick="location.href='home.do'">Click</button>
	<br/><br/><br/><br/><br/>
	<!-- LIST를 클릭하면 list.do의 값으로 요청된다. -->
	<!-- 그럼 Controller에 list.do가 RequestMapping이 해당 메소드와 연결해줘서 실행해줄거다. -->
	LIST : <button onclick="location.href='list.do'">Click</button>
	<br/><br/><br/><br/><br/>
	Login : <button onclick="location.href='loginform.do'">Click</button>

</body>
</html>