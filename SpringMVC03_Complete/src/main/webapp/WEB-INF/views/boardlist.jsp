<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.mvc.spring.model.dto.MemberDto"%>
<%
	// 로그인 후 로그아웃하고 뒤로가기 버튼을 클릭했을 때에도 로그인이 되어있는 현상을 방지
	response.setHeader("pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.addHeader("Cache-Control","No-store");
	response.setDateHeader("Expires",1L);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectList</title>

<script type="text/javascript">

var msg = '${msg}';
if(msg != ''){
	alert(msg);
}

</script>

<style type="text/css">

h3{
	text-align : center;
	color : blue;
}

</style>

</head>
<body>
<%
	// session에 저장되어있는 객체 가져오기.
	MemberDto dto = (MemberDto) request.getSession().getAttribute("login");
	// 가져온 객체에서 이름만 뽑아서 담기.
	String name = dto.getMembername();
%>
	<h1>selectList</h1>
	<h3><%= name %>님 환영합니다.</h3> 
	<%
		if(dto != null){
	%>
		<button onclick="location.href='logout.do'">LogOut</button>
	<%
		}
	%>
	<table>
	<colgroup>
		<col width="50"/>
		<col width="100"/>
		<col width="300"/>
		<col width="100"/>
	</colgroup>
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>MYDATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">조회된 글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.myno }</td>
						<td>${list.myname }</td>
						<td><a href="detail.do?myno=${list.myno }">${list.mytitle }</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.mydate }"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<button onclick="location.href='insert.do'">Insert</button>
			</td>
		</tr>
	</table>
</body>
</html>