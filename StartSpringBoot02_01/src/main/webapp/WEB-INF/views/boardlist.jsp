<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css"/>
<script type="text/javascript" src="/js/script.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>List</h1>
	
	<table>
	<colgroup>
		<col width="50"/> 
		<col width="100"/>
		<col width="300"/>
		<col width="300"/>
	</colgroup>
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						조회된 글이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.myno }</td>
						<td>${list.myname }</td>
						<td><a href="detail?myno=${list.myno }">${list.mytitle }</a></td>
						<td>${list.mydate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4">
				<input type="button" value="글작성" onclick="location.href='insertform'"/>
			</td>
		</tr>
	</table>
</body>
</html>