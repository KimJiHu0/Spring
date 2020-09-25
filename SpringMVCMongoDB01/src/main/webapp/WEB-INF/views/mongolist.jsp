<%@page import="com.mvc.mongo.dto.ScoreMongoDto"%>
<%@page import="java.util.List"%>
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
	List<ScoreMongoDto> list = (List<ScoreMongoDto>) request.getAttribute("list");
%>

	<h1>MongoList</h1>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>KOR</th>
			<th>ENG</th>
			<th>MATH</th>
		</tr>
			<%
				for(int i = 0; i < list.size(); i++){
			%>
				<tr>
					<td><%=list.get(i).getId() %></td>
					<td><%=list.get(i).getName() %></td>
					<td><%=list.get(i).getKor() %></td>
					<td><%=list.get(i).getEng() %></td>
					<td><%=list.get(i).getMath() %></td>
				</tr>
			<%
				}
			%>
			<tr>
				<td colspan="5">
					<input type="button" value="점수입력하기" onclick="location.href='insertform.do'"/>
				</td>
			</tr>
	</table>

</body>
</html>