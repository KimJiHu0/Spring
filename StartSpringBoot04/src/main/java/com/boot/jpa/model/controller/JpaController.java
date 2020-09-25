package com.boot.jpa.model.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.dto.JpaDto;

@Controller
@RequestMapping("/member")
public class JpaController {
	
	@Autowired
	private JpaDao dao;
	
	
	
	
	@GetMapping("/list")
	public String selectList(Model model) {
		
		model.addAttribute("list", dao.findAll());
		
		return "jpalist";
	}
	
	
	@GetMapping("detail")
	public String detail(int myno, Model model) {
		
		model.addAttribute("dto", dao.findByMyno(myno));
		return "jpadetail";
	}
	
	@GetMapping("updateform")
	public String updateForm(int myno, Model model) {
		model.addAttribute("dto", dao.findByMyno(myno));
		return "jpaupdateform";
	}
	
	@PostMapping("updateres")
	public String updateRes(JpaDto dto, Model model) {
		
		JpaDto res = dao.save(dto);
		
		if(res != null) {
			model.addAttribute("dto", dao.findByMyno(dto.getMyno()));
			return "redirect:detail?myno=" + dto.getMyno();
		} else {
			model.addAttribute("dto", dao.findByMyno(dto.getMyno()));
			return "redirect:updateform?myno=" + dto.getMyno();
		}
		
	}

	@GetMapping("/insertform")
	public String insertForm() {
		return "jpainsert";
	}
	
	@PostMapping("/insertres")
	public String insertRes(JpaDto dto) {
		
		dto.setMydate(new Date());
		dao.save(dto);
		
		return "redirect:list";
		
	}
	
	@GetMapping("delete")
	public String delete(int myno, Model model) {
		
		dao.deleteByMyno(myno);
		model.addAttribute("list", dao.findAll());
		return "redirect:list";
	}
	
}
