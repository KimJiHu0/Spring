<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script type="text/javascript">

var msg = '${msg}';
if(msg != ''){
	alert(msg);
}

</script>

<script type="text/javascript">
	$(function(){
		$("#loginchk").hide();
	});
	
	function loginPrc(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		if(memberid == null || memberid == '' || memberpw == null || memberpw == ''){
			alert("ID와 PW를 제대로 입력해주세요.");
		} else {
			$.ajax({
				contentType : "application/json",
				data : JSON.stringify(loginVal),
				dataType : "json",
				url : "ajaxlogin.do",
				type : "post",
				success : function(msg){
					if(msg.check == true){
						location.href="list.do";
					} else {
						$("#loginchk").show();
						$("#loginchk").html("ID와 PW를 잘못 입력하셨습니다.").css("color", "red");
					}
				},
				error : function(){
					alert("연결실패");
				}
			})
		}
	}
</script>

</head>
<body>
	<h1>Login</h1>
	
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="Login" onclick="loginPrc();"/>
				<input type="button" value="Regist" onclick="location.href='registform.do'"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="loginchk"></td>
		</tr>
	</table>
	
</body>
</html>