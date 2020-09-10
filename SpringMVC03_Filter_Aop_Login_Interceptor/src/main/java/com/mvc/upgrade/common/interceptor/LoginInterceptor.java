package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * Interceptor : 
 * Controller에 들어오는 요청 HttpRequest와
 * Controller가 응답하는 HttpResponse를 가로채는 역할
 * 
 * 관리자만 접근할 수 있는 관리자 페이지에 접근하기 전 관리자 인증하는 용도로 활용할 수 있음.
 * 
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// dispatcherServlet -> Controller갈 때
		// Controller가 호출되기 전
		logger.info("[ LoginInterceptor ] preHandle");
		
		// loginform.do로 넘어가거나 ajaxlogin.do 거나 session에 값이 담겨있다면. 즉, 로그인이 되어있다면
		// 이 조건일때만 dispatcherServlet에서 Controller로 넘어갈 수 있다.
		// spring 3.2 이상부터는 servlet-context.xml에서 <exculude-mapping-path>를 통해서 설정할 수 있다.
		if(request.getRequestURI().contains("/loginform.do") ||
				request.getRequestURI().contains("/ajaxlogin.do") ||
				request.getSession().getAttribute("login") != null ||
				request.getRequestURI().contains("/registform.do") ||
				request.getRequestURI().contains("registres.do")) {
			// Controller 보내주겠다.
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {
			// 로그인이 안되어있다면.
			// 세션에 login이라는 이름의 값이 없다면.
			// loginform으로 넘어가게 한다.
			response.sendRedirect("loginform.do");
			return false;
		}
		// Controller 안보내주겠다.
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// controller가 dispatcherServlet에 return할때
		// Controller가 실행된 후
		logger.info("[ LoginInterceptor ] postHandle");
		// controller가 return해줄 객체가 뭔지 알아보는 logger.
		logger.info(modelAndView.getViewName());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 최종 결과가 생성하는 일을 포함한 모든 일이 완료되었을 때 실행
		logger.info("[ LoginInterceptor ] afterHandle");
	}

}
