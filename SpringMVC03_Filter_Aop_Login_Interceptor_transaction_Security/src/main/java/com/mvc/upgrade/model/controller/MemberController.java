package com.mvc.upgrade.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {

	@Autowired
	private MemberBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("loginform.do")
	public String loginForm() {
		logger.info("[loginform.do]");
		return "mvclogin";
	}
	
	// 비동기 통신으로 요청된 url와 HandlerMapping을 통해서 현재 메소드와 연결해준다.
	// key:value형식으로 담아서 값을 return하기 위해서 map을 사용했다.
	
	// @RequestBody : ajax에서 넘어온 json형태의 문자열을 MemberDto dto의 형식에 맞게
	// 값을 주입시킨다고 볼 수 있다.
	
	// @ResponseBodt : 현재 메소드에서 값을 처리하고 response할 때 json으로 보내야하기 때문에
	// 알아서 결과값을 json으로 바꿔주는 거라고 볼 수 있다.
	
	// 이들 은 jackson시리즈가 자동적적으로 해준다.
	@RequestMapping(value="ajaxlogin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String , Boolean> ajaxlogin(@RequestBody MemberDto dto, HttpSession session){
		
		// 로그인에서 암호화한 것을 출력하려고 하면 안된다.
		// 회원가입할 때 암호화 한 것을 또 다시 암호화 하려고 했기 때문에
		// 오류가 난다.
		// dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		// logger.info("\n 로그인 암호화 된 memberpw : " + dto.getMemberpw());
		
		MemberDto res = biz.login(dto);
		
		logger.info(" controller : " + res.getMemberpw());
		
		boolean check = false;
		if(res != null) {
			// 전자는 사용자가 입력한 password, 후자는 db에 저장된, 암호화된 password
			// 내부적으로 사용자가 입력한 pw와 db에 암호화되어 저장된 pw를 매칭.
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				logger.info(" \n [ 사용자가 입력한 memberpw ] : " + dto.getMemberpw());
				logger.info(" \n [ db에 암호화 되어 저장된 memberpw ] : " + res.getMemberpw());
				session.setAttribute("login", res);
				check = true;
			}
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	// Regist버튼을 클릭했을 때 registform으로 이동하게끔 만들어줄건데
	// 요청된 값 registform.do를 handlermapping을 통해서 현재 메소드와 연결해준다.
	@RequestMapping(value="registform.do", method = RequestMethod.GET)
	public String registForm() {
		return "mvcregistform";
	}
	
	// ID,PW,NAME을 입력하고 OK버튼을 누르면 넘어오는 값 registres.do를 HandlerMapping을 통해서
	// 현재 메소드와 연결해준다.
	// 회원가입이 완료되면 alert를 띄어주고 로그인창으로 가게 만들거다.
	@RequestMapping(value="registres.do", method = RequestMethod.POST)
	public String registRes(MemberDto dto, RedirectAttributes msg) {
		
		// 암호화하기
		// 회원가입 할 때 사용자가 입력한 암호를
		// dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));를 통해서 암호화 해준다.
		// 그리고 암호화 된걸 logger로 출력
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		logger.info("\n 회원가입 암호화 된 memberpw : " + dto.getMemberpw());
				
		// return에 redirect를 사용하게되면 Model객체에 내가 원하는 메세지를 담아서 보낼 수 없다.
		// redirect를 사용하지 않으면 새로고침을 누를때마다 uri가 남아있어서 insert가 무한적으로 된다.
		// 이를 방지하기 위해서 redirect를 사용했고, 이 때 내가 원하는 메세지를 같이 넘기기 위해서
		// RedirectAttribute를 사용했다.
		// add.FlashAttribute를 사용하면 값을 넘길 수 있다.
		
		int res = biz.regist(dto);
		if(res > 0) {
			msg.addFlashAttribute("msg", "회원가입에 성공했습니다. 로그인 해주세요.");
			return "redirect:/loginform.do";
		} else {
			msg.addFlashAttribute("msg", "회원가입에 실패했습니다. 다시 진행해주세요.");
			return "redirect:/registform.do";
		}
	}
}
