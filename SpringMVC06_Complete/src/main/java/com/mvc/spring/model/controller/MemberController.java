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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.spring.model.biz.MemberBiz;
import com.mvc.spring.model.dto.MemberDto;

@Controller
public class MemberController {

	@Autowired
	private MemberBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/signin.do")
	public String signUp() {
		logger.info("[ Controller ] SignIn ");
		return "membersignIn";
	}
	
	@RequestMapping("ajaxsignin.do")
	@ResponseBody
	public Map<String, Object> ajaxsignup(@RequestBody MemberDto dto, HttpSession session){
		
		logger.info("[ Controller ] AjaxSignin");
		
		MemberDto res = biz.signin(dto);
		boolean check = false;
		String id = dto.getMemberid();
		if(res != null){
			session.setAttribute("signin", res);
			System.out.println(session.getAttribute("signin").getClass());
			check = true;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("check", check);
		map.put("id", id);
		
		return map;
	}
		// adminPage
		@RequestMapping("adminpage.do")
		public String adminpage() {
			return "adminpage";
		}
	
	@RequestMapping("signup.do")
	public String signUpFrom() {
		return "membersignup";
	}
	
	@RequestMapping("signupres.do")
	public String signUpRes(MemberDto dto, RedirectAttributes msg) {
		
		int res = biz.signup(dto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "회원가입에 성공했습니다. 로그인을 진행해주세요");
			return "redirect:signin.do";
		} else {
			msg.addFlashAttribute("msg", "회원가입에 실패했습니다. 다시 회원가입 해주세요.");
			return "redirect:signup.do";
		}
	}
	
	@RequestMapping("logout.do")
	public String logOut(HttpSession session, RedirectAttributes msg) {
		
		session.invalidate();
		msg.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:signin.do";
	}
}
