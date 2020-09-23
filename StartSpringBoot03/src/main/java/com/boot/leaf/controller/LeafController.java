package com.boot.leaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.model.dto.LeafDto;

@Controller
public class LeafController {
	
	@GetMapping("/hello")
	public String Hello(Model model) {
		model.addAttribute("name", "Juuu");
		return "hello";
	}
	
	@GetMapping("util")
	public String Util() {
		return "utility";
	}
	
	@GetMapping("/expr")
	public String Expression(Model model) {
		
		model.addAttribute("name", "Thymeleaf");
		LeafDto dto = new LeafDto("java", 1);
		model.addAttribute("dto", dto);
		
		List<LeafDto> list = new ArrayList<LeafDto>();
		list.add(new LeafDto("DataBase", 2));
		list.add(new LeafDto("jsp/servlet", 3));
		model.addAttribute("list", list);
		
		
		return "expression";
	}
	
	@GetMapping("params")
	public String Params(Model model, HttpSession session) {
		
		model.addAttribute("dto", new LeafDto("Spring", 4));
		session.setAttribute("pw", "qclass");
		
		return "params";
	}
	
	@GetMapping("static")
	public String Static() {
		return "static";
	}

}
