package com.mvc.spring.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	
	@RequestMapping("login.do")
	public String login() {
		return "memberlogin";
	}
	
	@RequestMapping("ajaxlogin.do")
	@ResponseBody
	public Map<String, Boolean> ajaxlogin(@RequestBody MemberDto dto, HttpSession session) {
		
		MemberDto res = biz.login(dto);
		boolean check = false;
		if(res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		
		return map;
	}
	
	@RequestMapping("registform.do")
	public String registForm() {
		return "memberregistform";
	}
	
	@RequestMapping("registres.do")
	public String registRes(MemberDto dto, RedirectAttributes msg) {
		
		int res = biz.regist(dto);
		if(res > 0) {
			msg.addFlashAttribute("msg", "회원가입에 성공했습니다. 로그인해주세요");
			return "redirect:/login.do";
		} else {
			msg.addFlashAttribute("msg", "회원가입에 실패했습니다. 회원가입을 다시 진행해주세요");
			return "redirect:/registform.do";
		}
	}
	
	@RequestMapping("logout.do")
	public String logOut(HttpSession session,RedirectAttributes msg) {
		session.invalidate();
		msg.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/login.do";
	}
}
