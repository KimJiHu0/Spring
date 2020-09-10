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

</script>s

<script type="text/javascript">
	
	// jsp가 켜지자마자 실행되는 함수로써
	// 실행되면 id가 loginchk인 태그를 숨겨준다
	$(function(){
		$("#loginchk").hide();
	});
	
	// login버튼을 클릭했을 때 실행되는 함수
	function loginPrc(){
		// memberid라는 변수에 id가 memberid의 val을 공백제거 후 담고
		var memberid = $("#memberid").val().trim();
		// memberpw라는 변수에 id가 memberpw의 val을 공백제거 후 담고
		var memberpw = $("#memberpw").val().trim();
		// loginVal이라는 객체리터럴에 json형태로 값을 담는다.
		// memberid라는 이름으로 memberid를 담고
		// memberpw라는 이름으로 memberpw를 담는다.
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		// 만일 memberid가 null이거나 공백이거나 memberpw가 null이거나 공백일 때.즉, id혹은 pw 중 하나라도 입력을 안했다면
		if(memberid == null || memberid == "" || memberpw == null || memberpw == ""){
			alert("ID와 PW를 모두 입력해주세요.");
		} else {
			// 그렇지않고 입력을 다 했다면 ajax실행
			$.ajax({
				// 타입은 post
				type:"post",
				// 연결할 url은 ajaxlogin.do라는 값
				url:"ajaxlogin.do",
				// 보내는 data는 json형태의 String이며 loginVal을 보낼거다.
				data:JSON.stringify(loginVal),
				// 보낼 때 작성하는?
				contentType:"application/json",
				// 받는 data타입은 json
				dataType:"json",
				// 만일 성공했다면 연결된 url에서 처리된 결과값을 msg라는 이름으로 받아온다.
				success : function(msg){
					// msg에 check가 true라면
					if(msg.check == true){
						// list.do로 이동해준다.
						alert("로그인에 성공하였습니다.");
						location.href="list.do";
						// msg.check가 false라면
					} else {
						// id가 loginchk인 애를 다시 보여주고
						$("#loginchk").show();
						// html을 바꾸고 css를 넣어준다.
						$("#loginchk").html("ID 혹은 PW를 잘못 입력하셨습니다.").scc("color", "red");
					}
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
			<td	colspan="2">
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