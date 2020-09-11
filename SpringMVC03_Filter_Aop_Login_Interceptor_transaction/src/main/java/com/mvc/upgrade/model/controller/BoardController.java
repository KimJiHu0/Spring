package com.mvc.upgrade.model.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.biz.BoardBizImpl;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(BoardBizImpl.class);
	
	@RequestMapping("list.do")
	public String selectList(Model model) {
		
		List<BoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		
		return "boardlist";
	}
	
	@RequestMapping("detail.do")
	public String detail(Model model, int myno) {
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "boarddetail";
	}
	
	@RequestMapping("insertform.do")
	public String insertForm() {
		return "insertform";
	}
	
	@RequestMapping("insertres.do")
	public String insertRes(Model model, BoardDto dto) {
		
		int res = biz.insert(dto);
		if(res>0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:/list.do";
		} else {
			return "redirect:/insertform.do";
		}
	}
	
	@RequestMapping("updateform.do")
	public String updateForm(Model model, int myno) {
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "updateform";
	}
	
	@RequestMapping("/test.do")
	public String transactionTest() {
		
		logger.info("[ test.do ]");
		
		biz.transactionTest();
		
		return "redirect:list.do";
	}

}
