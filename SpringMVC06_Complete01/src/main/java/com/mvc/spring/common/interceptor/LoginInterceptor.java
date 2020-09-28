package com.mvc.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getRequestURI().contains("/loginform.do")) {
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
		
		if(request.getSession().getAttribute("login") != null) {
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
			return true;
		}
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
