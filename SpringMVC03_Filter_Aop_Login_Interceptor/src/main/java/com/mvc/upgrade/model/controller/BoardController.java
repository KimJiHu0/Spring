package com.mvc.upgrade.model.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

// controller이라는걸 의미하는 어노테이션
@Controller
public class BoardController {
	
	// biz와 controller를 연결해주는 어노테이션이라고 볼 수 있다.
	// biz의 결과값을 자동으로 담아서 사용할 수 있게 해준다.
	@Autowired
	private BoardBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("list.do")
	public String selectList(Model model) {
		logger.info("[ Print selectList ]");
		
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
	
	@RequestMapping("updateform.do")
	public String updateForm(Model model, int myno) {
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "boardupdateform";
	}

}
