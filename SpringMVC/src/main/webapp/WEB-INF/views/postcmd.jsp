<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>/command.do를 통해 post방식으로 보냈을 때 return되는 jsp </h1>
	
	<p>
		index.jsp에서 form태그로 post방식으로 값을 controller에 보냈어.
		요청값에 해당하는 <b>command.do</b>가 받아들이고 그 전에 <b>listener</b>를 거쳐 어떤 xml을 연결해줄지 정한 후,
		<b>DispatcherServlet</b>를 통해서 어떤 메소드를 연결해줄지 정해서 연결해줘.
		이는 <b>@RequestMapping</b>이라고도 할 수 있어.
		그럼 그 값들은 해당 메소드의 파라미터로 들어가게 되는데 파라미터로 AddressDto dto를 받아왔어.
		그 말은 말 그대로 dto에 setter로 값을 가져와 초기화시켜준 후에 model에 담아서 보내주겠다는 의미야.
		보내준 값은 dto라는 이름으로 담아서 보냈기 때문에 해당 jsp에서 $.{dto.} 을 이용해서 쓸 수 있어.
	</p>
	
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>ADDR</th>
			<th>PHONE</th>
		</tr>
		<tr>
			<td>${dto.name }</td>
			<td>${dto.addr }</td>
			<td>${dto.phone }</td>
		</tr>
	</table>
	<button onclick="location.href='index.jsp'">index.jsp로</button>
</body>
</html>