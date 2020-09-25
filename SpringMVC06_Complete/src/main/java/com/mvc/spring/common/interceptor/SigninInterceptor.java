package com.mvc.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.spring.model.dto.MemberDto;

public class SigninInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			MemberDto dto = (MemberDto) request.getSession().getAttribute("signin");
		
			if(request.getRequestURI().contains("/signin.do")) {
				return true;
			}
			if(request.getRequestURI().contains("/ajaxsignin.do")) {
				return true;
			}
			if(request.getRequestURI().contains("/signup.do")) {
				return true;
			}
			if(request.getRequestURI().contains("/signupres.do")) {
				return true;
			}
			if(request.getRequestURI().contains("/logout.do")) {
				return true;
			}
			if(request.getSession().getAttribute("signin") != null) {
				return true;
			}
			if(request.getRequestURI().contains("/adminpage.do")) {
				return true;
			}
			if(request.getSession().getAttribute("signin") == null) {
				response.sendRedirect("signin.do");
				return false;
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
