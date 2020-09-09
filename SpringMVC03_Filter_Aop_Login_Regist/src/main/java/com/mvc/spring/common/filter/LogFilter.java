package com.mvc.spring.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	
	/*
	 * Filter : Client와 Server 사이에 무언가 처리를 해준다.
	 * FilterChain : filter가 여러개일 경우는 filter와 filter를 연결해주고, filter와 Server를 연결해준다.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 아래의 형태로 변환해주겠다는 의미.
		HttpServletRequest req = (HttpServletRequest) request;
		
		// [ 정보들을 출력해주는 것들 ]
		// Client IP
		String remoteAddr = req.getRemoteAddr();
		// URL (도메인) 에서 하위부분
		String uri = req.getRequestURI();
		// URL 전체
		String url = req.getRequestURL().toString();
		// 불러올 때 사용된 QUERY
		String queryString = req.getQueryString();
		// 이전 페이지. 즉, 요청보낸 페이지
		String referer = req.getHeader("referer");
		// 사용자 정보
		String agent = req.getHeader("User-Agnet");
		
		StringBuffer sb = new StringBuffer();
		sb.append("1. remoteAddr : " + remoteAddr + "\n")
		  .append("2. uri : " + uri + "\n")
		  .append("3. url : " + url + "\n")
		  .append("4. queryString : " + queryString + "\n")
		  .append("5. referer : " + referer + "\n")
		  .append("6. agent : " + agent + "\n");
		
		System.out.println("[ LogFilter ]");
		System.out.println(sb);
		
		// filter와 filter 혹은 filter와 server을 연결해주는 
		chain.doFilter(req, response);
		
	}

	@Override
	public void destroy() {

	}

}
