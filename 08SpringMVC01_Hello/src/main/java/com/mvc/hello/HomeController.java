package com.mvc.hello;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws UnsupportedEncodingException 
	 */
	// 요청 넘어오는거 핸들러 넘어서 여기로옴
	// 디스패처 : 어떤 컨트롤러를 호출해줄건지 찾아주고 넘겨주는데 값도 같이 넘겨줘
	// 기본적으로 /를 호출하면 여기 오고, GET방식으로만 동작해
	// 둘 다 쓰려면 GET,POST둘다 쓰거나 아예 생략해
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// 얘는 로그찍어주는거야.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// 원래 /WEB-INF/ ... 로 리턴했는데 이번엔 뷰리졸버에 저장되어있음.
		return "home";
	}
	
}
