<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
	})
	
	function loginPrc(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		if(memberid == '' || memberid == null || memberpw == '' || memberpw == null){
				alert("아이디와 비밀번호를 제대로 입력해주세요.");
		} else {
			$.ajax({
				type : "post",
				data : JSON.stringify(loginVal),
				dataType : "json",
				contentType : "application/json",
				url : "ajaxlogin.do",
				success : function(msg){
					if(msg.check == true){
						alert("로그인에 성공했습니다.");
						if(msg.id == "admin"){
							location.href="adminpage.do";
						} else {
							location.href="list.do";
						}
					} else {
						$("#loginchk").show();
						$("#loginchk").html("아이디 혹은 비밀번호가 틀립니다.").css("color", "red");
					}
				},
				error : function(){
					alert("연결 실패");
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
			<td>
				<input type="text" id="memberid"/>
			</td>
		</tr>
		<tr>
			<th>PW</th>
			<td>
				<input type="text" id="memberpw"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="loginPrc();">Login</button>
				<input type="button" value="Regist" onclick="location.href='registform.do'"/>
			</td>
		</tr>
		<tr>
			<td id="loginchk" colspan="3"></td>
		</tr>
	</table>

</body>
</html>