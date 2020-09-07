package com.mvc.spring.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


// Filter : 클라이언트와 서버 사이에서 원하는 것을 처리해준다.
// 무언가를 처리하고 서버 혹은 필터로 전달하는데 이때 연결해주는 것인
// FilterChain이 있어야한다.
// 이렇게 작성을 다 했다면 web.xml에서 설정을 해줘야한다.
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	// filterChain : 클라이언트에서 서버로 넘어오는 사이에 필터가 있는데
	// 필터가 또 있을수 있고, 서버로 넘어간다 치자.
	// 이 때 첫번째 필터에서 뭐뭐하고 두번째 필터로 넘어갈 때
	// filterChain이 연결해준다.
	// filter and filter Or filter and Servlet connection
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 여기에 log를 찍을거임.
		// 아래의 형태로 바꿔서 log 찍을거야.
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 클라이언트 IP값
		String remoteAddr = req.getRemoteAddr();
		// 웹 서버로 요청 시, 요청에 사용된 URL로 부터 URI값을 리턴 (도메인 이후 하부 주소)
		String uri = req.getRequestURI();
		// 웹 서버로 요청 시, 요청된 URL (호출된 FULL 주소)
		String url = req.getRequestURL().toString();
		// 웹 서버로 요청 시 요청에 사용된 queryString
		String queryString = req.getQueryString();
		
		// 이전 페이지 (보내는 페이지 )URL
		String referer = req.getHeader("referer");
		// 사용자 정보 (브라우저, OS 기타 등등)
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();

		sb.append("* remoteAddr : " + remoteAddr + "\n")
		  .append("* uri : " + uri + "\n")
		  .append("* url : " + url + "\n")
		  .append("* queryString : " + queryString + "\n")
		  .append("* regerer : " + referer + "\n")
		  .append("* agent : " + agent);
		
		System.out.println("LogFilter");
		System.out.println(sb);
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}

}
