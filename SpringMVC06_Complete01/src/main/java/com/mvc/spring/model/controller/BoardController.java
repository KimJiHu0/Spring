package com.mvc.spring.model.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.spring.model.biz.BoardBiz;
import com.mvc.spring.model.dto.BoardDto;

@Controller
public class BoardController {

	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardBiz biz;
	
	
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		logger.info("Controller : selectList");
		
		List<BoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		
		return "boardlist";
	}
	
	@RequestMapping("insertform.do")
	public String insertForm() {
		return "boardinsertform";
	}
	
	@RequestMapping(value="insertres.do", method = RequestMethod.POST)
	public String insertRes(BoardDto dto, RedirectAttributes msg) {
		
		int res = biz.insert(dto);
		if(res > 0) {
			msg.addFlashAttribute("msg", "글 작성에 성공했습니다.");
			return "redirect:list.do";
		} else {
			msg.addFlashAttribute("msg", "글 작성에 실패했습니다.");
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping("detail.do")
	public String detail(int boardno, Model model) {
		
		BoardDto dto = biz.selectOne(boardno);
		model.addAttribute("dto", dto);
		
		return "boarddetail";
		
	}
	
	@RequestMapping("updateform.do")
	public String updateForm(int boardno, Model model) {
		
		BoardDto dto = biz.selectOne(boardno);
		model.addAttribute("dto", dto);
		
		return "boardupdateform";
		
	}
	
	@RequestMapping(value="updateres.do", method = RequestMethod.POST)
	public String updateRes(BoardDto dto, RedirectAttributes msg) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "수정에 성공했습니다.");
			return "redirect:detail.do?boardno=" + dto.getBoardno();
		} else {
			msg.addFlashAttribute("msg", "수정에 실패했습니다.");
			return "redirect:updateform.do?boardno=" + dto.getBoardno();
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(int boardno, RedirectAttributes msg) {
		
		int res = biz.delete(boardno);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "삭제에 성공했습니다.");
			return "redirect:list.do";
		} else {
			msg.addFlashAttribute("msg", "삭제에 실패했습니다.");
			return "redirect:detail.do?boardno=" + boardno;
		}
		
	}
	
}
