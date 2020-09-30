package com.mvc.spring.model.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.spring.model.biz.BoardBiz;
import com.mvc.spring.model.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private BoardBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("boardlist.do")
	public String selectList(Model model) {
		
		logger.info("[ controller : selectList ]");
		
		List<BoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		
		return "boardlist";
	}
	
	@RequestMapping("insertform.do")
	public String insertForm() {
		return "boardinsertform";
	}
	
	@RequestMapping("insertres.do")
	public String insertRes(BoardDto dto, Model model) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:insertform.do";
		}
	}
	
}
