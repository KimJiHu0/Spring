package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



// Interceptor을 만들었다면 servlet-context.xml에서 설정을 해줘야한다.

// HandlerInterceptor을 꼭 impl 해준다.
public class LoginInterceptor implements HandlerInterceptor {
	
	// Interceptor : 
	// Controller에 들어오는 요청 HttpRequest와
	// Controller이 응답하는 HttpResponse를 가로채서 처리하는 역할
	// 관리자만 접근할 수 있는 관리자 페이지에 접근하기 전에 관리자 인증을 하는 용도로 사용할 수 있다.

	// System.out.println 대신에 logger를 찍기 위해 전역변수로 선언
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	// DispatcherServlet에서 Controller로 갈 때.
	// 즉, Controller이 호출되기 전에 DispatcherServlet 와 Controller 사이에 존재.
	// Filter는 Cilent와 Server 사이에 존재
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("\n [ PreHandle ]");
		
		// spring 3.2 version 이상부터는 servlet-context.xml에서 <exculude-mapping-path>를 통해서 설정할 수 있다.
		
		// 만일 DispatcherServlet에서 Controller로 요청하는 URI값이 loginform.do라면
		// 넘어가는 걸 허락하겠다. : return true;
		if(request.getRequestURI().contains("/loginform.do")) {
			return true;
			
		}
		
		// 만일 DispatcherServlet에서 Controller로 요청하는 URI값이 ajaxlogin.do라면
		// 넘어가는걸 허락하겠다. : return true;		
		if(request.getRequestURI().contains("/ajaxlogin.do")) {
			return true;
			
		}
		
		// 만일 DispatcherServlet에서 Controller로 넘어갈 때 Session에 담겨있는 값이 login이라는 이름으로
		// NOT NULL이라면. 즉, 존재한다면
		// 넘어가는걸 허락하겠다. : return true;
		if(request.getSession().getAttribute("login") != null) {
			return true;
			
		} 
		
		// test.do라는 요청이 들어오게 되면 return true
		if(request.getRequestURI().contains("/test.do")) {
			return true;
		}
		
		// 만일 DispatcherServlet에서 Controller로 넘어갈 때 URI가 registform.do라면 보내줘라.
		if(request.getRequestURI().contains("/registform.do")) {
			return true;
		}
		
		if(request.getRequestURI().contains("/registres.do")) {
			return true;
		}

		
		// 만일 DispatcherServlet에서 Controller로 넘어갈 때 Session에 담겨있는 값이 login이라는 이름으로
		// NULL 상태라면. 즉, 존재하지 않는다면
		// 넘어가는걸 허락하지 않겠다. : return false;
		if(request.getSession().getAttribute("login") == null) {
			// 그리고 로그인이 존재하지 않기 때문에 loginform으로 이동시켜준다.
			response.sendRedirect("loginform.do");
			return false;
		} 
		
		return false;
	}

	
	// Controller가 Dispatcher로 응답할 때.
	// ModelAndView객체를 응답할거야.
	// Controller가 실행된 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("\n [ PostHandle ]");
		// Controller가 return해줄 때 view의 이름이 무엇인지 알아볼 수 있다.
		// logger.info(modelAndView.getViewName());
		
		// preHandle과 postHandle과 aftercompletion이 모두 실행됐지만
		// logger.info(modelAndView.getViewName());에서 오류가 났다.
		// ajax는 비동기이기 때문에 modelAndView에 담겨져 있는 값이 없어서 오류가 난다.
		// 원래는 modelAndView에 값이 담아져서 전달되어야 한다.
		
		// 아래와 같은 경우는 ajax가 로그인에 성공했다면 list.do를 요청했고,
		// BoardController에서 list.do를 RequestMapping한 Method가 그 요청을 받아서
		// 처리하고 modelAndView 객체에 return "boardlist"를 보내줬기 때문에
		// view가 출력이 되고 modelAndView에는 boardlist가 담겨 있다.
		// 그래서 아래와 같이 Null이 아닐때 라는 조건문이 성립이 되는 것이고
		// 성공적으로 logger을 찍어준다.
		if(modelAndView != null) {
			logger.info("\n [ModelAndView] "+modelAndView.getViewName());
		}

	}

	
	// 최종 결과가 생성하는 일을 포함한 모든 일이 완료되었을 때 실행.
	// View가 rendering된 이후에 실행되는 메소드.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("\n [ AfterCompletion ]");

	}

}
