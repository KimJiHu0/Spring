<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl쓰려면 이거 써줘야돼 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		Controller에서 Model 객체에 list라는 이름으로 값을 보냈다.
		따로 받아줄 필요는 없고 그냥 쓰기만 하면 된다.
	 -->

	<h1>LIST</h1>
	<table border="1">
		<colgroup>
			<col width="50"/>
			<col width="100"/>
			<col width="300"/>
			<col width="100"/>
		</colgroup>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<!-- 만일 list가 empty(비어있다면)하다면 작성된 글이 없습니다. 출력 -->
			<c:when test="${empty list }">
				<tr>
					<th colspan="4"> 작성된 글이 없습니다. </th>
				</tr>
			</c:when>
			<!-- 그게 아니고 값이 있다면 값을 출력해준다. -->
			<c:otherwise>
				<!-- list에 담겨져있는 객체들을 for문을 돌건데 이름을 dto라고 칭한다. -->
				<c:forEach items="${list }" var="dto">
					<tr>
						<!-- dto에 있는 myno, myname, mytitle, mycontent, mydate를 출력해준다. -->
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<!-- 제목을 클릭한다면 detail.do라는 값을 보내주는데 같이 가져갈 값은 현재 클릭한 -->
						<!-- 글의 myno를 보내줄거다. -->
						<td><a href="detail.do?myno=${dto.myno }">${dto.mytitle }</a></td>
						<!-- fmt태그는 jstl fmt taglib을 작성하여 사용할 수 있다. -->
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.mydate}"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<!-- 만일 글 작성버튼을 누르게 된다면 insertform.do라는 값을 보내준다. -->
				<input type="button" value="글작성" onclick="location.href='insertform.do'"/>
			</td>
		</tr>
	</table>


</body>
</html>