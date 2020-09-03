<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp</title>
</head>
<body>
	<h1>가장 먼저 들어와지는 경로 /</h1>
	
	<!-- <a href="home.do">Go Home</a> -->
	
	<!-- 
		GO List를 클릭하게 되면 list.do를 찾아서 간다. 이 때 listener는 어떤 xml을 연결해줄지 찾은 다음에 DispatcherServlet와
		연결해준다.
		DispatcherServlet : 어떤 Controller과 연결해줄지 찾아준다.
	 -->
	<h1><a href="list.do">Go List</a></h1>
</body>
</html>