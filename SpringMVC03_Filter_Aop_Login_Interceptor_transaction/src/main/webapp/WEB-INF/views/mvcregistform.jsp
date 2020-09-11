<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegistForm</title>
<script type="text/javascript">

// regist 후에 가입이 실패했다면 현재 jsp로 오는데 이때 msg에 값을 담아서 넘어오게 된다.
// 이를 이용해서 alert를 띄워야 한다.

// 넘어온 값 msg를 msg라는 변수에 담는다.
var msg = '${msg}';
// 만일 msg가 빈값이 아니라면. 즉, 제대로 들어왔다면
if(msg != ''){
	// msg를 alert로 띄어준다.
	alert(msg);
}

</script>
</head>
<body>
	<h1>RegistForm</h1>
	
	<form action="registres.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid" placeholder="Write ID"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="memberpw" placeholder="Write PW"/></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername" placeholder="Write NAMES"/></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="OK"/>
					<input type="button" value="Cancel" onclick="location.href='loginform.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>