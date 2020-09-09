package com.mvc.spring.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.spring.model.biz.MemberBiz;
import com.mvc.spring.model.dto.MemberDto;

// Controller Class라는 것을 의미하는 Annotation
@Controller
public class MemberController {

	// biz와 controller를 연결해주는 것이라고 볼 수 있다.
	@Autowired
	private MemberBiz biz;
	
	// Controller에서 System.out.println을 대신해서 Logger를 찍기 위해 전역변수 선언.
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	// index.jsp에서 Login버튼을 클릭하게 되면 넘어오는 값 loginform.do를 HandlerMapping을 통해서
	// 현재 Method와 연결해준다.
	// 로그인창으로 이동하기 위해서 return "내가 원하는 jsp이름"; 을 작성한다.
	// servlet-context에서 viewResolver가 perfix와 suffix를 통해
	// return 값 앞 뒤에 경로를 붙여줘서 원하는 jsp로 이동하게 해준다.
	@RequestMapping("loginform.do")
	public String loginForm() {
		// index.jsp에서 로그인버튼을 눌렀을 때 제대로 들어가는지 찍어주는 logger
		logger.info("[ loginform.do ]");
		return "memberlogin";
	}
	
	// 넘어오는 값은 ajaxlogin.do이고 post방식으로 넘어오는 것만 받아줄거라는 의미다.
	@RequestMapping(value="ajaxlogin.do", method=RequestMethod.POST)
	// ResponseBody : java객체를 reponse객체의 데이터로 binding해준다는 의미.
	// 이 login method에서 무언가 처리하고 response하려고 한다.
	// memberlogin은 받는 데이터타입이 json이다. 그렇기 때문에
	// json으로 값을 보내줘야하는데 이를 ResponseBody가 처리해준다.
	// @ResponseBody, @RequestBody는 jackson-core / jack을 통해서 값을 변형시켜준다.
	@ResponseBody
	// login할 때 memberid값과 memberpw값을 받기 위해 parameter에 적었고, session은 내가 로그인하면 남겨두기 위해서 받았다.
	// @RequestBody : memberlogin.jsp에서 json형태의 문자열로 값을 보냈을 때
	// MemberDto dto에 binding해준다.
	// json형태로 넘어온 문자열을 dto에 넣어주는 역할을 한다.
	public Map<String, Boolean> login(@RequestBody MemberDto dto, HttpSession session) {
		// 이 메소드로 잘 들어왔는지 찍어보는 logger
		logger.info("[ ajaxlogin.do ]");
		
		// res라는 변수에 login메소드를 실행한 결과값을 담아준다.
		MemberDto res = biz.login(dto);
		
		// 아직 로그인에 성공하지 못했을 때에는 check변수가 false이다.
		boolean check = false;
		// 만일 로그인에 성공했다면
		if(res != null) {
			// session객체에 login이라는 이름으로 결과를 담아준다.
			session.setAttribute("login", res);
			// 로그인에 성공했기 때문에 check변수를 true로 바꿔준다.
			check = true;
		}
		// 로그인에 성공해서 check가 true로 바뀐 것을 map에 k:v 형식으로 담는다.
		// 그럼 담아지는 값은 {"check" : true} 가 map에 담겨서 return 되는데
		// memberlogin.jsp의 ajax로 return되게 된다.
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
}
