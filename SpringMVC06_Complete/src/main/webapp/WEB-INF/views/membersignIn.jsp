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
		$("#idchk").hide();
	})
	
	function signIn(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		if(memberid == "" || memberid == null || memberpw == "" || memberpw == null){
			alert("ID와 PW를 제대로 입력해주세요.");
		} else {
			$.ajax({
				
				type : "post",
				contentType : "application/json",
				dataType : "json",
				data : JSON.stringify(loginVal),
				url : "ajaxsignin.do",
				success : function(msg){
					if(msg.check==true){
						alert("로그인에 성공했습니다.");
						if(msg.id == "admin"){
							location.href="adminpage.do";
						} else {
							location.href="list.do";
						}
					} else {
						$("#idchk").show();
						$("#idchk").html("ID 혹은 PW를 잘못 입력하셨습니다. 다시 로그인을 진행해주세요.").css("color", "red");					}
				},
				error : function(){
					alert("통신 실패");
				}
				
			})
		}
	}

</script>

</head>
<body>

	<h1>Sign up</h1>
	
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
			<td colspan="3">
				<input type="button" value="SignIn" onclick="signIn();"/>
				<input type="button" value="SignUp" onclick="location.href='signup.do'"/>
			</td>
		</tr>
		<tr>
			<td colspan="3" id="idchk"></td>
		</tr>
	</table>

</body>
</html>