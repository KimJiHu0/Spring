<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 상세보기</h1>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="myname" readonly="readonly" value="${dto.myname }"/>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="mytitle" readonly="readonly" value="${dto.mytitle }"/>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="60" name="mycontent" readonly="readonly">${dto.mycontent }</textarea>
			</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.mydate}"/></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<!-- 수정버튼을 누른다면 updateform.do를 요청하는데 myno를 보내는 이유는 -->
				<!-- 내가 클릭한 하나의 dto를 원해서 selectOne으로 출력해주기 위함이다. -->
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno }'"/>
				<!-- 삭제버튼을 클릭하게 되면 delete.do를 요청하고 내가 원하는 하나의 dto 삭제를 원하기 때문에 -->
				<!-- myno값을 함께 보내준다. -->
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno }'"/>
			</td>
		</tr>
	</table>
</body>  
</html>