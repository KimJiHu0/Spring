package com.mvc.mongo;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.mongo.dao.ScoreMongoDao;
import com.mvc.mongo.dto.ScoreMongoDto;

@Controller
public class HomeController {
	
	@Autowired
	private ScoreMongoDao scoremongodao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// mongodb
		
		// list에 findAll한거 다 담아주고
		List<ScoreMongoDto> list = scoremongodao.findAll();
		// ScoreMongoDto 타입인 dto에 list를 하나하나 담아준다.
		for(ScoreMongoDto dto : list) {
			// 그리고 그걸 출력
			System.out.println(dto);
		}
		
		return "home";
	}
	
}
