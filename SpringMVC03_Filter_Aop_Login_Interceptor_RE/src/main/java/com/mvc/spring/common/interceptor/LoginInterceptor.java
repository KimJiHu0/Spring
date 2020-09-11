package com.mvc.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// HandlerInterceptor을 상속받아서 class를 생성해야한다.
public class LoginInterceptor implements HandlerInterceptor {

	// interceptor : D/S와 Controller의 사이에서 호출되는 것을 가로채어서 아래의 메소드들을 처리해준다.
	// filter : Client와 Server의 사이에서 무언가를 처리하는 것을 FilterChain을 통해서 filter & filter 혹은 filter & server
	// 를 연결해준다.
	
	// interceptor을 생성하고 작성을 했다면 sevlet-context.xml에서 등록 설정을 해줘야한다.
	
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	// D/S에서 Controller로 넘어갈 때 거치는 메소드 : preHandle
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("[ preHandle ]");
		
		// loginform.do라는 요청이 들어오게 되면 이 메소드를 거쳐
		// return이 true인지 false인지 확인 후에 true면 실행 / false면 실행x
		if(request.getRequestURI().contains("loginform.do")) {
			return true;
		}
		
		// uri가 ajaxlogin.do면 controller로 넘겨준다.
		if(request.getRequestURI().contains("ajaxlogin.do")) {
			return true;
		}
		
		// uri가 registform.do면 controller로 넘겨준다.
		if(request.getRequestURI().contains("registform.do")) {
			return true;
		}
		
		// uri가 registres.do면 controller로 넘겨준다.
		if(request.getRequestURI().contains("registres.do")) {
			return true;
		}
		
		// session객체에 담은 이름이 login이고 null이 아니라면. 즉, 로그인이 되어있다면
		// controller로 넘겨준다.
		if(request.getSession().getAttribute("login") != null) {
			return true;
		}
		
		// 만일 login이라는 이름으로 null이 라면
		//loginform.do 로 보내주고 controller로 넘어가는걸 막는다.
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		return false;
	}

	
	// Controller에서 D/S로 넘어갈 때 거치는 메소드 : postHandle
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("[ postHandle ]");
		
		// ajax에서 바로 넘어오는 것은 modeAndView에 아무것도 담겨있지 않기 때문에
		// if조건을 빼고 logger만 찍으려면 오류가 난다.
		// 왜? modelAndView에는 아무 값도 없기 때문이다.
		
		// 하지만 ajax 마지막에 로그인에 성공하면 list.do를 보내주는 것에서 controller로 가고,
		// 처리를 한 결과를 model객체에 담아서 보내기 때문에 현재 if문의 조건이 성립하며
		// 출력의 결과는 boardlist가 나온다.
		if(modelAndView != null) {
			logger.info(modelAndView.getViewName());
		}
	

	}

	
	// view가 보여진 후에 실행되는 메소드 : afterCompletion
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("[ afterCompletion ]");

	}

}
