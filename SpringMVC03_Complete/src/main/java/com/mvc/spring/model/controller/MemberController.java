package com.mvc.spring.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.spring.model.biz.MemberBiz;
import com.mvc.spring.model.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@RequestMapping("login.do")
	public String loginForm() {
		logger.info("[ login.do ]");
		return "loginform";
	}
	
	@RequestMapping(value="ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> ajaxlogin(@RequestBody MemberDto dto, HttpSession session){
		
		logger.info("[ ajaxlogin.do ]");
		
		
		MemberDto res = biz.login(dto);
		
		logger.info("\n [ Controller dto password ] : " + dto.getMemberpw());
		logger.info("\n [ Controller res password ] : " + res.getMemberpw());
		
		boolean check = false;
		if(res != null) {
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				logger.info("\n [ 사용자가 입력한 memberpw ] : " + dto.getMemberpw());
				logger.info("\n [ 암호화해서 db에 저장한 memberpw ] : " + res.getMemberpw());
				session.setAttribute("login", res);
				
				check = true;
			}
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
		
	}
	
	@RequestMapping("registform.do")
	public String registForm() {
		return "registform";
	}
	
	@RequestMapping("registres.do")
	public String registRes(MemberDto dto, RedirectAttributes msg) {
		
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		logger.info("\n [ 회원가입 시 암호화된 memberpw ] : " + dto.getMemberpw());
		
		int res = biz.regist(dto);
		if(res > 0) {
			msg.addFlashAttribute("msg", "회원가입에 성공했습니다. 로그인해주세요");
			return "redirect:/login.do";
		} else {
			msg.addFlashAttribute("msg", "회원가입에 실패했습니다. 다신 회원가입을 해주세요");
			return "redirect:/registform.do";
		}
	}
	
	
	// 로그아웃 버튼을 눌렀을 때
	@RequestMapping("logout.do")
	public String logOut(HttpSession session, RedirectAttributes msg) {
		// session에 담겨져있는 값을 지워준다. (로그아웃)
		session.invalidate();
		msg.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/login.do";
	}
}
