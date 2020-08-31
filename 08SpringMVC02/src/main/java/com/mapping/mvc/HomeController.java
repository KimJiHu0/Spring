package com.mapping.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mapping.mvd.model.dto.AddressDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// /home.do로 요청이 들어오면 여기로 올거야.
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// command.do가 get방식으로 넘어오면 이게 실행
	@RequestMapping(value="/command.do", method = RequestMethod.GET)
	// String address 로 받았다. 원래 변수명 addr인데!!
	// 그래서 @RequestParam("addr") 을 이용해서 addr이라는 이름을 저기에 담겠다 해줘야대
	public String getCommand(Model model, String name, @RequestParam("addr")String address, String phone) {
		
		// 해당 view한테 전달하는 값들을 Model객체가 받아서 전달해줘 view로
		// request.setAttribute("dto", dto)의 역할을 해준다.
		model.addAttribute("dto", new AddressDto(name, address, phone));
		
		return "getcmd";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	// AddressDto dto 안에 setter를 찾아서 3개의 값들이 저장될거야. (스프링이 알아서 넣어줄거야)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		
		model.addAttribute("dto", dto);
		
		return "postcmd";
	}
	
	// 얘가 handler mapping야.
	@RequestMapping("/void.do")
	public void voidPage(Model model) {
		// msg에 void page라는 String을 담아서 보낸다.
		// 디스패처에 넘겨줘.
		
		// return타입이 없으면 .do앞에있는애 찾아.
		// 그게 void니까 void.jsp를 찾겠지?
		// 만약에 aaa.do면 aaa.jsp를 찾아줄거야
		model.addAttribute("msg", "void page");
		
	}
	
}
