package com.mvc.upgrade.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {

	@Autowired
	private MemberBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("loginform.do")
	public String loginform() {
		return "memberloginform";
	}
	
	/*
	 * @ResponseBody : 메소드에서 처리된 결과값을 ajax로 다시 보낼 때 json으로 보내야하는데 현재
	 * Map타입이기 때문에 이를 json으로 변경해줘야한다.
	 * 이를 해주는게 ResponseBody이다.
	 * 
	 * @RequestBody : ajax에서 보내는 json형태의 String을 MemberDto dto의 형식에 맞게 담아준다.
	 * 
	 * Client와 View사이에서는 jackson-asl / jack-core-asl 이 처리를 해준다.
	 * 대신 spring 4.x버전부터는 jackson-dbinding을 사용한다.
	 */
	@RequestMapping(value="ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> login(@RequestBody MemberDto dto, HttpSession session) {
		
		logger.info("[ Ajax Login ]");
		
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
		return "registform";
	}
	
	// RedirectAttributes은 return이 redirect일 때 값을 보내주기 위한 객체.
	@RequestMapping("registres.do")
	public String registRes(MemberDto dto, RedirectAttributes rttr) {
		
		int res = biz.regist(dto);
		if(res > 0) {
			rttr.addFlashAttribute("msg", "회원가입에 성공하셨습니다. 로그인을 해주세요.");
			return "redirect:/loginform.do";
		} else {
			rttr.addFlashAttribute("msg", "회원가입에 실패했습니다. 다시 입력해 주세요.");
			return "redirect:/registform.do";
		}
	}
	
}
