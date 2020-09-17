package com.mvc.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.update.biz.JDBCBiz;
import com.mvc.update.dto.JDBCDto;

@Controller
public class JDBCController {
	
	@Autowired
	private JDBCBiz biz;
	
	
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "jdbclist";
	}
	
	
	@RequestMapping("detail.do")
	public String selectOne(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		return "jdbcdetail";
	}
	
	@RequestMapping("insert.do")
	public String insertForm() {
		return "jdbcinsertform";
	}
	
	@RequestMapping("insertres.do")
	public String insertRes(JDBCDto dto, RedirectAttributes msg) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "글 작성에 성공했습니다.");
			return "redirect:/list.do";
		} else {
			msg.addFlashAttribute("msg", "글 작성에 실패했습니다.");
			return "redirect:/insertform.do";
		}
	}
	
	@RequestMapping("updateform.do")
	public String updateform(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectOne(seq));
		
		return "jdbcupdateform";
	}
	
	@RequestMapping("updateres.do")
	public String updateRes(JDBCDto dto, RedirectAttributes msg) {
		
		int res = biz.update(dto);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "수정에 성공했습니다.");
			return "redirect:/detail.do?seq=" + dto.getSeq();
		} else {
			msg.addFlashAttribute("msg", "수정에 실패했습니다.");
			return "redirect:/updateform.do?seq=" + dto.getSeq();
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(int seq, RedirectAttributes msg) {
		
		int res = biz.delete(seq);
		
		if(res > 0) {
			msg.addFlashAttribute("msg", "삭제에 성공했습니다.");
			return "redirect:/list.do";
		} else {
			msg.addFlashAttribute("msg", "삭제에 실패했습니다.");
			return "redirect:/detail.do?seq=" + seq;
		}
	}
}
