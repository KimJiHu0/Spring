<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style type="text/css">
	h1{
		background-color : black;
		color : white;
		text-align : center;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>selectList</h1>
	
	<table border="1">
	<colgroup>
		<col width="50"/>
		<col width="100"/>
		<col width="300"/>
		<col width="100"/>
	</colgroup>
		<tr>
			<th>NO.</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>MYDATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">-----조회된 글이 없습니다.-----</td>
				</tr>
			</c:when>
			<c:otherwise>
			<!-- items : 어떤걸 for문 돌릴거야? -->
			<!-- var : 어떤 이름으로 쓸건데? -->
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
				<button onclick="location.href='insertform.do'">글작성</button>
			</td>
		</tr>
	</table>
</body>
</html>