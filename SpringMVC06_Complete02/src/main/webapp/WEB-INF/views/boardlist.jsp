<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

onload=function(){
	startTime();
}

function startTime() {
    var today = new Date();
    var mon = today.getMonth();
    var date = today.getDate();
    var day = today.getDay();
    var week = ['일','월','화','수','목','금','토']
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('clock').innerHTML =
    mon + 1 + "월" + date + "일" + week[day] + "요일 <br/>" + h + "시" + m + "분" + s + "초";
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i}; // 숫자가 10보다 작을 경우 앞에 0을 붙여줌
    return i;
}
</script>

<style type="text/css">

	h3{
		color : gray;
	}

</style>

</head>
<body>

	<h1>BoardList</h1>
	<h3 id="clock"></h3>
	
	<table>
		<colgroup>
			<col width="50"/>
			<col width="100"/>
			<col width="300"/>
			<col width="200"/>
		</colgroup>
		<tr>
			<th>NO</th>
			<th>TITLE</th>
			<th>NAME</th>
			<th>DATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						작성된 글이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.boardno }</td>
						<td>${list.boardtitle }</td>
						<td>${list.boardname }</td>
						<td>${list.boarddate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="insert" onclick="location.href='insertform.do'"/>
			</td>
		</tr>
	</table>

</body>
</html>