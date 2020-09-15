<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>DownLoad Page</h1>
	
	file : ${fileObj.name }<br/>
	desc : ${fileObj.desc }
	
	<form action="download" method="post">
		<input type="hidden" name="name" value="${fileObj.name }"/>
		<input type="submit" value="download"/>
	</form>
	
	<!-- 
	
		tomcat web.xml 아래쪽 mome-type(Multipurpose Internet Mail Extension)
		브라우저에서 받는 데이터가 어떤 타입인지 알려준다.
		request header에 지정되는, 데이터가 어떤 종류의 stream인지를 나타내는 프로토콜
	
		* mime-type 추가하기
		<mime-mapping>
			<extension></extension>
			<mime-type>application/unknown</mime-type>
		</mime-mapping>
	
	 -->

</body>
</html>