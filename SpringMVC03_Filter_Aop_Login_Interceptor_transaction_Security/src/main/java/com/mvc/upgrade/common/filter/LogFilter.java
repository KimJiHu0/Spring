package com.mvc.upgrade.common.filter;

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

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = req.getRemoteAddr();
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		String referer = req.getHeader("referer");
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("1. remoteAddr : " + remoteAddr + "\n")
		  .append("2. uri : " + uri + "\n")
		  .append("3. url : " + url + "\n")
		  .append("4. queryString : " + queryString + "\n")
		  .append("5. referer : " + referer + "\n")
		  .append("6. agent : " + agent);
		
		System.out.println("[ Log Filter ]");
		System.out.println(sb);
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}

}
