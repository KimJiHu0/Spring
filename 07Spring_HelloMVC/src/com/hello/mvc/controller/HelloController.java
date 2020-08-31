package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.biz.HelloBiz;

// 얘는 이제 Controller이야!
// 자동으로 Controller로 잡혀
@Controller
public class HelloController {
	
	// TODO : 05. BIZ(@Servlet) 호출
	@Autowired
	private HelloBiz biz;
	
	// TODO : 04. handler mapping("/hello.do") 통해서 controller의 메서드를 찾아온다.
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		// TODO : 09. return받은 값을 model 객체에 담아서 전달 (ModelAndView)
		model.addAttribute("message", biz.getHello());
		return "/WEB-INF/views/hello.jsp";
	}
	
	
	// @RequestParam("name")에서 넘어온 값을 String nickname에 저장할거야
	// bye.do라는 요청이 들어오면 아래의 method실행
	@RequestMapping("/bye.do")
	public ModelAndView getBye(@RequestParam("name") String nickname) {
		// controller가 dispatcherservlet에게 다시 응답할 때
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "Bye, " + nickname);
		
		return mav;
	}
	
	/*
	 	@RequestMapping()
	 		- url을 class또는 method와 mapping시켜주는 역할
		
		@RequestParam : GET방식
			- 이전화면에서 request하면서 같이 넘어오는 파라미터를 controller안에서 연결해주는 역할
			- key = value 형태로 넘어오는 queryString(Parameter)을 mapping된 method의 parameter와 연결
		@ModelAttribute : POST방식
			- form 태그를 통해 넘어온 model을 mapping된 method의 parameter와 연결
		@SessionAttribute
			- session 객체에 model 정보를 유지하고 싶을 경우 사용
		@
	 */
}
