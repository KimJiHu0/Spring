package com.mvc.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.mongo.dao.ScoreMongoDao;
import com.mvc.mongo.dto.ScoreMongoDto;

@Controller
public class ScoreMongoController {
	
	@Autowired
	private ScoreMongoDao dao;
	
	@RequestMapping("list.do")
	public String list(Model model) {
		
		List<ScoreMongoDto> list = dao.findAll();
		model.addAttribute("list", list);
		return "mongolist";
	}
	
	@RequestMapping("insertform.do")
	public String insertform() {
		return "mongoinsertform";
	}

}
