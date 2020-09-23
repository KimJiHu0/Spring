<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- css파일 설정법 -->
<link rel="stylesheet" href="resources/css/test.css"/>
<title>Insert title here</title>
</head>
<body>

	<!-- 
		첫 url : http://localhost:8787 에서 아래의 List... 를 클릭하면
		url : http://localhost:8787/myboard/list 이다.
		그럼 /myboard인 곳을 찾는다.
		MyBoardController.java에 requestMapping이 /myboard로 되어있음.
		그래서 그 controller로 가는데
		getMapping("/list")랑 연결되어있는 메소드를 찾아서 list 출력해준다.
		그 안에서 페이지 이동하는것은
		http://localhost:8787/myboard 가 기본으로 되어있고 뒤에 uri만 적어주면 되기 때문?
		그래서 location.href=""에 /myboard를 안써도됌?
	 -->
	<h1><a href="myboard/list">List...</a></h1>

</body>
</html>