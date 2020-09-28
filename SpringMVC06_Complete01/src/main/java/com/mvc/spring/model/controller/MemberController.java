package com.mvc.spring.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping("loginform.do")
	public String loginform() {
		return "memberloginform";
	}
	
	@RequestMapping("ajaxlogin.do")
	@ResponseBody
	public Map<String, Object> ajaxlogin(@RequestBody MemberDto dto, HttpSession session){
		 
		MemberDto res = biz.login(dto);
		String id = dto.getMemberid();
		
		boolean check = false;
		if(res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("check", check);
		map.put("id", id);
		
		return map;
	}
	
	@RequestMapping("logout.do")
	public String logOut(HttpSession session, RedirectAttributes msg) {
		session.invalidate();
		msg.addFlashAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:loginform.do";
	}
	
	@RequestMapping("registform.do")
	public String registForm() {
		return "memberregistform";
	}
	
	@RequestMapping(value="registres.do", method = RequestMethod.POST)
	public String registRes(MemberDto dto, RedirectAttributes msg) {
		int res = biz.regist(dto);
		if(res > 0) {
			msg.addFlashAttribute("msg", "회원가입에 성공했습니다. 로그인해주세요");
			return "redirect:loginform.do";
		} else {
			msg.addFlashAttribute("msg", "회원가입에 실패했습니다. 다시진행해주세요");
			return "redirect:registform.do";
		}
	}
	
	@RequestMapping("adminpage.do")
	public String adminpage() {
		return "adminpage";
	}
}
