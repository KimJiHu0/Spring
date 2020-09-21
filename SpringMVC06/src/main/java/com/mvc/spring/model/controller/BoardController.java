package com.mvc.spring.model.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.spring.model.biz.BoardBiz;
import com.mvc.spring.model.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private BoardBiz biz;
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		logger.info(" \n [ Controller : selectList ]");
		
		List<BoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		return "boardlist";
	}
	
	@RequestMapping("insertform.do")
	public String insertForm() {
		logger.info(" \n [ Controller : insertForm ]");
		return "boardinsertform";
	}
	
	@RequestMapping("insertres.do")
	public String insertRes(BoardDto dto, RedirectAttributes msg) {
		logger.info(" \n [ Controller : insertRes ]");
		int res = biz.insert(dto);
		if(res > 0) {
			msg.addFlashAttribute("msg", "글 작성에 성공했습니다.");
			return "redirect:/list.do";
		} else {
			msg.addFlashAttribute("msg", "글 작성에 실패했습니다.");
			return "redirect:/insertform.do";
		}
	}
	
	@RequestMapping("detail.do")
	public String detailForm(int myno, Model model) {
		logger.info("\n [ Controller : detailForm ]");
		
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		
		return "boarddetail";
	}
	
	@RequestMapping("updateform.do")
	public String updateForm(int myno, Model model) {
		logger.info(" \n [ Controller : updateForm ]");
		BoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "boardupdateform";
	}
	
	@RequestMapping("updateres.do")
	public String updateRes(BoardDto dto, RedirectAttributes msg) {
		logger.info(" \n [ Controller : updateRes ]");
		
		int res = biz.update(dto);
		if(res > 0) {
			msg.addFlashAttribute("msg", "수정에 성공했습니다.");
			return "redirect:/detail.do?myno=" + dto.getMyno();
		} else {
			msg.addFlashAttribute("msg", "수정에 실패했습니다.");
			return "redirect:/updateform.do?myno=" + dto.getMyno();
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(int myno, RedirectAttributes msg) {
		logger.info(" \n [ Controller : delete ]");
		int res = biz.delete(myno);
		if(res > 0) {
			msg.addFlashAttribute("msg", "삭제에 성공했습니다.");
			return "redirect:/list.do";
		} else {
			msg.addFlashAttribute("msg", "삭제에 실패했습니다.");
			return "redirect:/detail.do?myno=" + myno;
		}
	}

}
