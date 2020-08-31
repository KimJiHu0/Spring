<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%=request.setCharacterEncoding("UTF-8") %>
<%=response.setCharacterEncoding("text/html; charset=UTF-8") %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<button onclick="location.href='index.jsp'">index.jsp로</button>
</body>
</html>
