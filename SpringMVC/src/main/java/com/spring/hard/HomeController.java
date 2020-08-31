package com.spring.hard;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hard.dto.AddressDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// @ReqeustMapping는 요청이 들어왔을때 해당 컨트롤러와 연결해주는 DispatcherServlet와 같은 역할을 한다고 볼 수 있어.
	// /home.do라는 요청이 들어오면 해당 메소드를 실행시켜 줄거야.
	// 그리고 method방식은 GET방식만 가능해.
	// 둘 다 써주고 싶으면 GET, POST를 둘다 써주고나 혹은 생략이 가능해
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// command.do라는 요청이 들어오고 GET방식일 때 아래의 메소드 실행
	// HANDLERMAPPING 즉, DispatcherServlet과 동일하다고 볼 수 있어.
	@RequestMapping(value="/command.do", method = RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr") String address, String phone) {
		
		// 해당 view한테 전달하는 값들을 Model객체가 받아서 전달해줘 view로
		// request.setAttribute("dto", dto)의 역할을 해준다.
		model.addAttribute("dto", new AddressDto(name, address, phone));
		
		// getcmd.jsp라는 jsp로 return해줄거야.
		// servlet-context.xml에 prefix, suffix에서 앞뒤로 설정한 값을 더해줘서 getcmd라는 jsp를 찾아가는거야.
		return "getcmd";
	}
	
	// command.do라는 값으로 넘어오게되면 dispatcherServlet를 통해서 어떤 메소드와 연결해줄지 정해주는데
	// 이 메소드의 경우 post방식으로 보내졌을때만 이 메소드가 실행돼
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	// AddressDto dto는 index.jsp에서 넘어온 값을 dto에 담아서 받은거?라고 생각해도 될듯
	public String postCommand(Model model, AddressDto dto) {
		
		// dto라는 이름으로 파라미터로 받은 dto를 담아준 후에 model에 담아줘서 값을 보내줘
		model.addAttribute("dto", dto);
		
		// postcmd는 servlet-context.xml에 prefix, suffix에 지정되있는 앞과 뒤 경로를 붙여준 후에
		// 해당 jsp를 실행시켜줄거야
		return "postcmd";
	}
	
	@RequestMapping("/void.do")
	public void getVoid(Model model) {
		// msg라는 이름으로 후자에 있는 String을 담을거야.
		// 그리고 model에 담을거고.
		
		// 현재 return타입이 없잖아?
		// do앞의 값이 void잖아? 그럼 void.jsp를 찾을거야.
		// 만일 do 앞이 aaa면 aaa.jsp를 찾을거야
		model.addAttribute("msg", "void.do로 받아서 메세지를 msg에 담아서 보낼거야.");
	}
	
}
