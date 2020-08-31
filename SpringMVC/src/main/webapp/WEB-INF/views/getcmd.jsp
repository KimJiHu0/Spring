<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>/command.do 를 통해 get방식으로 보냈을 때 return되는 jsp</h1>
	<p>
		index.jsp에서 <b>"Get방식 Command보내기"</b>를 클릭했을 때 넘어가는 /command.do 값은
		listener을 통해서 DispatcherServlet와 연결을 해줄 것이고, DispatcherServlet는
		넘어온 해당 /command.do를 통해서 annotation이 지정된 메소드와 연결해줄거야.
		그럼 HomeController에서 @ReqeustMapping(value="/command.do", method=RequestMethod.GET)-를 찾아갈 것이고 후에
		그 메소드를 실행해줄거야.
		파라미터로 name, addr, phone를 받아왔기 때문에 이들을 view에게 전달해줄 수 있는 객체인
		<b>Model model</b>에 담아줄거야
		-model.addAttribute("dto", new AddressDto(name, addr, phone))- 는
		-request.setAttribute("dto", new AddressDto(name, addr, phone))- 와 같은 의미를 가지고 있어.
		그 메소드의 return값은 -servlet-context.xml-에서 지정해준 prefix, suffix를 통해서 앞뒤에 경로가 붙게 될거고
		getcmd를 return했기 때문에 getcmd.jsp를 찾아서 올거야.
		그럼 getcmd.jsp에서 $.{dto. } 를 통해서 값을 가져와서 사용할 수 있어.
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