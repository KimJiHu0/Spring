<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>List</h1>
	
	<table border="1">
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
			<th>DATE</th>
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
						<!-- 현재 jsp에서 제목을 누르면 detail로 가게 한다. -->
						<!-- myno값을 넘겨줘야하는데 이유는 내가 선택한 하나의 값을 넘겨주기 위해서다. -->
						<td><a href="detail.do?myno=${list.myno }">${list.mytitle }</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.mydate }"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<!-- 글작성을 클릭하면 insertform.do라는 값을 controller에 보내준다. -->
				<input type="button" value="글작성" onclick="location.href='insertform.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>