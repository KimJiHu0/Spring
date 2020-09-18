package com.mvc.update.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JDBCBiz;

@Controller
public class JDBCController {

	@Autowired
	private JDBCBiz biz;
	
	
	// 이 이름으로 넘어오면 넘겨준다
	// jsp도 저기로 들어감
	// void일 경우는 @RequestMapping("jdbclist.do")안에 jdbclist.jsp로 가짐
	// 이름이 같음
	@RequestMapping("/jdbclist.do")
	public void selectList(Model model) {
		model.addAttribute("list", biz.selectList());
	}
}
