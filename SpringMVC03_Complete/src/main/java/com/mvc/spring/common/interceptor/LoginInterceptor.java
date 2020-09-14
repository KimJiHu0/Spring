package com.mvc.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("\n [ preHandle ]");
		
		if(request.getRequestURI().contains("/login.do")) {
			return true;
		}
		
		if(request.getRequestURI().contains("/ajaxlogin.do")) {
			return true;
		}
		
		if(request.getRequestURI().contains("/registform.do")) {
			return true;
		}
		
		if(request.getRequestURI().contains("/registres.do")) {
			return true;
		}
		
		if(request.getRequestURI().contains("/logout.do")) {
			return true;
		}

		if(request.getRequestURI().contains("/test.do")) {
			return true;
		}
		
		
		if(request.getSession().getAttribute("login") != null) {
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("login.do");
			return false;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("\n [ postHandle ]");
		
		if(modelAndView != null) {
			logger.info(" \n [ ViewName ] : " + modelAndView);
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("\n [ afterCompletion ]");

	}

}
