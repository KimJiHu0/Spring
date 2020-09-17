<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

var msg = '${msg}';
if( msg != ''){
	alert(msg);
}

</script>
</head>
<body>

	<h1>List</h1>
	
	<table border="1">
	<col width="50"/>
	<col width="100"/>
	<col width="300"/>
	<col width="100"/>
		<tr>
			<th>SEQ</th>
			<th>WRITER</th>
			<th>TITLE</th>
			<th>REGDATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">작성된 글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.seq }</td>
						<td>${list.writer }</td>
						<td><a href="detail.do?seq=${list.seq }">${list.title }</a></td>
						<td>${list.regdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4">
				<input type="button" value="글작성" onclick="location.href='insert.do'"/>
			</td>
		</tr>
	</table>

</body>
</html>