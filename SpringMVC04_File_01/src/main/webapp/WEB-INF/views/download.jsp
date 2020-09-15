<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Download</title>
</head>
<body>

	<h1>Download</h1>

	<!-- File이름과 Description을 출력해준다. -->
	<!-- Controller에서 MAV에 담아준 fileObj에서 name과 desc를 꺼내 사용했다. -->
	File : ${fileObj.name }<br/>
	Description : ${fileObj.desc }
	
	<form action="download" method="post">
		<!-- name이라는 이름으로 fileObj의 name을 숨겨서 form태그가 submit이벤트가 발생했을 때 보내준다. -->
		<input type="hidden" name="name" value="${fileObj.name }"/>
		<input type="submit" value="download"/>
	</form>
	
	<!-- 
		tomcat web.xml 아래쪽에 mime-type(Multipurpose Unternet Mail Extension)
		브라우저에서 바든 데이터가 어떤 타입인지를 알려준다.
		request header에 지정되는, 데이터가 어떤 종류의 Strea인지를 나타내는 프로토콜
		
		* mime-type 추가하기
		<mime-mapping>
			<extension></extension>
			<mime-type>application/unknown</mime-type>
		</mime-mapping>
	 -->
</body>
</html>