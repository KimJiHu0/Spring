<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- form태그를 사용하기 위해서 작성해준다. -->    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>

	<h1>Upload</h1>
	<!-- 
		form:form 태그는 spring tag다. 위에서 선언해줄 때 uri가 springframework.org/tags/form인 것을 보고 유추할 수 있다.
		
		form:form, form:error 만 사용했는데, 이 말고도 form:input, ... 등등 여러가지가 있다.
		
		form:errors는 Errors, BindingResult를 사용할 때 command객체ㄹ의 특정 field(지금은 mpfile)에서
		발생하는 예외에 대한 메세지 출력이 가능하다.
		
		[ enctype 속성 ]
		1. applicaton/www-form-urlencoded : 문자들이 Encoding된다. (가장 default)
		2. multipart/form-data : file-upload하는 애
		3. text/plain : 문자들을 Encoding하지 않음을 명시
		
		id는 명시를 해주지 않았을 때에는 기본값이 [ command ] 이다.
		modelAttribute : form에 있는 요소들의 값을 채우기 위해서 사용될 객체를 request로부터 찾을 때 사용
		생각으로는 name을 지어준 것과 다름이 없다고 생각한다.
		
		
		file 올리는데 이름 : mpfile
		desc 작성후 이름 : desc
	 -->
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		File : <br/>
		<input type="file" name="mpfile"/>
		<!-- error의 경로는 mpfile이 저장되는 그 경로를 의미한다고 생각한다. -->
		<p style="color=red; font-weight=bold;"><form:errors path="mpfile"/></p>
		
		Description : <br/>
		<textarea rows="10" cols="40" name="desc"></textarea>
		<input type="submit" value="Send"/>
	</form:form>

</body>
</html>