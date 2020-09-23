package com.boot.jdbc.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {

	@Autowired
	private MyBiz biz;
	
	
	// get방식으로 요청이 들어올 때만
	@GetMapping("/list")
	public String selectList(Model model) {
		// 이 부분은 SpringMVC와 동일하게 작성
		model.addAttribute("list", biz.selectList());
		return "bootlist";
	}
	
	
	
	@GetMapping("/detail")
	public String detailForm(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "bootdetail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "bootupdateform";
	}
	
	
	// post방식으로 요청이 들어올 때만
	@PostMapping("/updateres")
	public String updateRes(MyDto dto, Model model) {
		
		int res = biz.update(dto);
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getMyno()));
			return "redirect:detail?myno="+dto.getMyno();
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getMyno()));
			return "redirect:updateform?myno=" + dto.getMyno();
		}
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "bootinsert";
	}
	
	@PostMapping("insertres")
	public String insertRes(MyDto dto, Model model) {
		
		int res = biz.insert(dto);
		if( res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list";
		}else {
			return "redirect:insertform";
		}
	}
	
	@GetMapping("/delete")
	public String delete(int myno, Model model) {
		
		int res = biz.delete(myno);
		
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list";
		} else {
			model.addAttribute("dto", biz.selectOne(myno));
			return "redirect:detail";
		}
	}
	
}
