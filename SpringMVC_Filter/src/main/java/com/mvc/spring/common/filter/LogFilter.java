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
	
	/*
	 * Filter : Client / Server 사이에 존재하는 것으로. 무언가를 처리할 때 사용된다.
	 * 말 뜻 그래도 무언가 해주는 의미라고 볼 수 있다.
	 * Filter / Filter 혹은 Filter / Server 로 연결 할 수 있다.
	 * FilterChain : 위에서 말했듯이 Filter / Filter 혹은 Filter / Server 사이에
	 * 연결해주는 것이다. 
	 */

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 여기서 log를 찍을 것이다.
		// LOG : 정보들을 뜻한다.
		// HttpServletRequest 의 형태로 바꿔서 찍을거라는 의미다.
		HttpServletRequest req = (HttpServletRequest) request;
		
		// Client의 IP주소를 출력한다.
		String remoteAddr = req.getRemoteAddr();
		// URL에서 하부 주소를 의미한다.
		// EX ] localhost:8787/springMVC/insert.do 가 URL이라고 하면
		// URI : insert.do가 된다.
		String uri = req.getRequestURI();
		// 요청에 사용된 도메인을 의미한다.
		// EX ] localhost:8787/springMVC/insert.do
		String url = req.getRequestURL().toString();
		// 요청에 사용된 query문을 의미한다.
		String queryString = req.getQueryString();
		// 이전페이지 URL [ 보내는 페이지의 URL ]
		String referer = req.getHeader("referer");
		// 사용자의 정보
		String agent = req.getHeader("User-agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("1. remote : " + remoteAddr + "\n")
		  .append("2. uri : " + uri + "\n")
		  .append("3. url : " + url + "\n")
		  .append("4. queryString : " + queryString + "\n")
		  .append("5. referer : " + referer + "\n")
		  .append("6. agent : " + agent + "\n");
		
		System.out.println("[ LOG Filter ]");
		System.out.println(sb);
		
		// 이제 chain으로 연결을 해주면 된다.
		// HttpServletRequest로 req라는 변수명을 사용했기 때문에
		// request에서 req로 변경해주면 된다.
		chain.doFilter(req, response);
				
		// 이 filter class를 작성을 다 했다면 web.xml에서 연결을 시켜줘야한다.

	}

	@Override
	public void destroy() {

	}

}
