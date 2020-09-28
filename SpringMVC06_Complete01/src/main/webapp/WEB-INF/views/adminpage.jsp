<%@page import="com.mvc.spring.model.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDto dto = (MemberDto) request.getSession().getAttribute("login");
%>

	<h1>AdminPage</h1>
	<h3><%=dto.getMembername() %>님 환영합니다.</h3>
	<button onclick="location.href='logout.do'">LogOut</button>

</body>
</html>