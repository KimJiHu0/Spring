<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	// 이 jsp가 화면에 출력됐을 때에는 이 함수가 1순위로 실행되기 때문에
	// id가 loginchk인 태그는 hide인 상태이다.
	$(function(){
		$("#loginchk").hide();
	});
	
	// Login버튼을 클릭했을 때 함수가 실행되는데 함수 이름은 loginPrc이다.
	function loginPrc(){
		// login버튼을 클릭하면
		// memberid라는 변수에 id가 memberid인 태그의 value값이 공백제거된 후 담아지고,
		var memberid = $("#memberid").val().trim();
		// memberpw라는 변수에 pw가 memberpw인 태그의 value값이 공백제거된 후 담아진다.
		var memberpw = $("#memberpw").val().trim();
		// 객체리터럴
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		// 만약에 memberid가 null이거나 공백이거나, memberpw가 null이거나 공백이라면. 즉, id와 pw를 모두 입력하지 않았다면
		if(memberid == null || memberid == "" || memberpw == null || memberpw == ""){
			alert("ID와 PW를 제대로 입력해주세요.");
		} else {
			// 그게 아니라면. 즉, id와 pw를 모두 입력했다면
			$.ajax({
				// 타입은 post방식
				type : "post",
				// url연결은 ajaxlogin.do로 연결
				url : "ajaxlogin.do",
				// 보내는 data는 위에서 객체리터럴로 선언한 memberid와 memberpw를 json형태의 string으로 보낸다.
				data : JSON.stringify(loginVal),
				// Server에 data를 보낼 때 사용.
				contentType : "application/json",
				// 받는 dataType는 json으로 받음.
				dataType : "json",
				// 만일 url과 연결 성공했다면
				success : function(msg){
					// msg는 MemberController에서 보내준 값 map을 의미한다.
					// 그럼 {"check" : true} 라는 값이 넘어왔을 것이다.
					// 이 말은 로그인이 되었다면을 의미한다.
					if(msg.check == true){
						// 로그인이 되었다면 list.do로 보내준다.
						location.href="list.do";
					} else{
						// 그렇지 않고 로그인에 실패했다면
						// 숨겨놨던 id가 loginchk인 애를 show해주고
						// html을 입력해주고 css를 입력해준다.
						$("#loginchk").show();
						$("#loginchk").html("ID 혹은 PW를 잘못 입력하셨습니다.").css("color", "red");
					}
				},
				// 만일 url과 연결이 실패했다면
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
			<td><input type="text" id="memberid"/></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="Login" onclick="loginPrc();"/>
				<input type="button" value="Regist" onclick="location.href='registform.do'"/>
			</td>
		</tr>
		<tr>
			<!-- 로그인이 제대로 되지 않았을 때 ajax로 문구를 출력하기 위한 공간 -->
			<td colspan="2" align="center" id="loginchk"></td>
		</tr>
	</table>
</body>
</html>