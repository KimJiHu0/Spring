package com.boot.jdbc.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MyBoardBiz;
import com.boot.jdbc.model.dto.MyBoardDto;


@Controller // 이곳은 controller이다. 를 의미
// index.jsp에서 리스트를 클릭하면 넘어오는 값 myboard/list를 풀어보면
// localhost:8787/myboard/list 이다.
// 여기서 /myboard라고 요청이 들어오면 이 controller과 연결 해달라는 HandlerMapping을 사용했다.
@RequestMapping("/myboard") 
public class MyBoardController {
	
	@Autowired
	private MyBoardBiz biz;

	
	// get방식으로 들어오는 /list 요청값만 받아준다.
	@GetMapping("list")
	public String list(Model model) {
		
		List<MyBoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		return "boardlist";
	}
	
	
	@GetMapping("insertform")
	public String insertForm() {
		return "boardinsertform";
	}
	
	// post방식으로 들어오는 요청값 insertres만 받아준다.
	@PostMapping("insertres")
	public String insertRes(MyBoardDto dto, Model model) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list";
		} else {
			return "redirect:insertform";
		}
	}
	
	@GetMapping("detail")
	public String detail(int myno, Model model) {
		
		MyBoardDto dto = biz.selectOne(myno);
		model.addAttribute("dto", dto);
		return "boarddetail";
	}
	
	@GetMapping("updateform")
	public String updateForm(int myno, Model model) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "boardupdateform";
	}
	
	@PostMapping("updateres")
	public String updateRes(MyBoardDto dto, Model model) {
		int res = biz.update(dto);
		
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getMyno()));
			return "redirect:detail?myno=" + dto.getMyno();
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getMyno()));
			return "redirect:updateform?myno=" + dto.getMyno();
		}
	}
	
	@GetMapping("delete")
	public String delete(int myno, Model model) {
		
		int res = biz.delete(myno);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list";
		} else {
			model.addAttribute("dto", biz.selectOne(myno));
			return "redirect:detail?myno=" + myno;
		}
		
	}
	
	
}
