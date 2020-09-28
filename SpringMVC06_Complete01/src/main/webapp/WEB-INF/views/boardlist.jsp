<%@page import="com.mvc.spring.model.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}

</script>

</head>
<body>
<%
	MemberDto dto = (MemberDto) request.getSession().getAttribute("login");
%>

	<h1>List</h1>
	<h3><%=dto.getMembername() %>님 환영합니다.</h3>
	<button onclick="location.href='logout.do'">LogOut</button>
	
	<table>
		<colgroup>
			<col width="50"/>
			<col width="100"/>
			<col width="300"/>
			<col width="200"/>
		</colgroup>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4">작성된 글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.boardno }</td> 
						<td>${list.boardname }</td>
						<td><a href="detail.do?boardno=${list.boardno }">${list.boardtitle }</a></td>
						<td>${list.boarddate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4">
				<input type="button" value="글작성" onclick="location.href='insertform.do'"/>
			</td>
		</tr>
	</table>

</body>
</html>