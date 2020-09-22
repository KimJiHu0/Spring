package com.mvc.spring.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();
		String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();
		String queryString = req.getQueryString();
		String referer = req.getHeader("Referer");
		String agent = req.getHeader("Agent : User");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("1. remoteAddr : " + remoteAddr + "\n")
		  .append("2. url : " + url + "\n")
		  .append("3. uri : " + uri + "\n")
		  .append("4. queryString : " + queryString + "\n")
		  .append("5. referer : " + referer + "\n")
		  .append("6. agent : " + agent + "\n");
		
		logger.info("\n[ LogFilter ]");
		System.out.println(sb);
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}

}
