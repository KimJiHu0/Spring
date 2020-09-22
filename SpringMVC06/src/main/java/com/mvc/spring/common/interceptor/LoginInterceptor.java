package com.mvc.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import oracle.ons.SenderThread;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// D/S에서 Controller로 넘어갈지 말지. 즉, return true할지 return false할지 정한다.
		
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
		// Controller에서 D/S로 넘어갈지 말지.
		if(modelAndView != null) {
			System.out.println("modelAndView : " + modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
