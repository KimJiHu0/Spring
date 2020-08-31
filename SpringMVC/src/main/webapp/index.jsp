<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>web.xml에 url-pattern을 "/"에서 "*.do" 로 변경을 했을 때</h1>
	<pre>
		url-pattern을 / 로 했을 때에는 요청이 /로 들어와서 Java Resources에 src/main/java에 Controller에 있는
		@RequestMapping이 실행되어 해당 메소드를 호출하게 되면서 return home.jsp를 해줬기 때문에
		home.jsp가 화면에 출력이 되었어
		
		url-pattern을 *.do로 했을 때에는 해당 요청과 맞는게 없기 때문에 오류가 나는건 당연한거고,
		만약에 현재 이 index.jsp가 없었다면 404가 계속 떴을거야.
		내부적으로 index.jsp , index.html이 가장 먼저 화면에 출력되기 때문에 오류없이 index.jsp가 화면이 출력돼
		(나는 그렇게 알고있어. 아니라면 알려줘!)
	</pre>
	<!-- Java Resources에 src/main/java에 Controller에 있는 home.do를 찾아서 간 후에 메소드 실행 -->
	<a href="home.do">home.jsp로 가자!</a>
	<br/>
	<!-- Java Resources에 src/main/java에 Controller에 이쓴 command.do를 찾아서 간 후에 메소드 실행 -->
	<a href="command.do?name=김지후&addr=인천&phone=010-0000-0000">Get방식 Command보내기</a>
	
	<h3>POST로 보내기</h3>
	<form action="command.do" method="post">
		이름 : <input type="text" name="name"/>
		주소 : <input type="text" name="addr"/>
		번호 : <input type="text" name="phone"/>
		
		<input type="submit" value="Post방식 Command보내기"/>
	</form>
	
	<br/>
	
	<!-- void.do라는 이름으로 보낼거야 -->
	<a href="void.do">void로 보내기</a>

</body>
</html>