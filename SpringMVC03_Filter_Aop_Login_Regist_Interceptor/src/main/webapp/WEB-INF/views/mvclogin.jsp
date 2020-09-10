<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script type="text/javascript">

// regist 후에 가입이 성공했다면 현재 jsp로 오는데 이때 msg에 값을 담아서 넘어오게 된다.
// 이를 이용해서 alert를 띄워야 한다.

// 넘어온 값 msg를 msg라는 변수에 담는다.
var msg = '${msg}';
// 만일 msg가 빈값이 아니라면. 즉, 제대로 들어왔다면
if(msg != ''){
	// msg를 alert로 띄어준다.
	alert(msg);
}

</script>
<script type="text/javascript">

	// html에서 id가 loginchk인 부분은 숨겨놔야한다.
	// 만일 로그인에 실패한다면 ajax로 문구를 출력해줄 곳이다.
	$(function(){
		$("#loginchk").hide();
	});
	
	// Login버튼을 클릭하게 되면 실행되는 함수이다.
	function loginPrc(){
		// memberid라는 변수에 memberid라는 id의 value값을 공백제거 후 담는다.
		var memberid = $("#memberid").val().trim();
		// memberpw라는 변수에 memberpw라는 id의 value값을 공백제거 후 담는다.
		var memberpw = $("#memberpw").val().trim();
		// 객체리터럴로 loginVal이라는 변수에 key : value형태로 값을 담는다.
		var loginVal = {
				"memberid":memberid,
				"memberpw":memberpw
		}
		// 만일 id나 pw를 입력하지 않았다면. 하나라도 입력되어있지 않다면
		if(memberid == null || memberid == "" || memberpw == null || memberpw == ""){
			alert("ID와 PW를 입력해주시기 바랍니다.");
		} else {
			// 만일 id나 pw를 제대로 입력했다면 ajax 실행
			$.ajax({
				// 타입은 post타입
				type:"post",
				// ...
				contentType:"application/json",
				// 연결 요청할 url
				url:"ajaxlogin.do",
				// 받는 타입 json
				dataType:"json",
				// 보내는 데이터 : json형태의 String. 변수 loginVal을 바꿔서 보내준다.
				data:JSON.stringify(loginVal),
				// 성공하면
				success : function(msg){
					// Controller에서 return해준 map은 {"check" : true} 으로 넘어왔다.
					if(msg.check == true){
						// 만일 넘어온 값 check의 value가 true라면 로그인이 된것이다.
						alert(" 로그인에 성공하였습니다. ");
						// list로 보내준다.
						location.href="list.do";
					} else {
						// 그렇지 않고 실패했다면 이제 숨겨놨던 태그를 보여주고
						$("#loginchk").show();
						$("#loginchk").html("ID와 PW를 잘못입력하셨습니다. 다시 입력해주세요.").css("color", "red");
					}
				},
				// 실패하면
				error : function(){
					alert("연결 실패")
				}
			})
		}
	}
	
</script>
</head>
<body>
	<h1>Login</h1>
	<table border="1">
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
			<td colspan="2" align="center" id="loginchk"></td>
		</tr>
	</table>
</body>
</html>