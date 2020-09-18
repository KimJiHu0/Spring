package com.mvc.update.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {
	
	// web.xml => javaClass로 바꿔주기.

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// web.xml에 있는거 전부다 java class로 바꿔준다.
	
		// ApplicationConfig
		AnnotationConfigWebApplicationContext applicationConfig = new AnnotationConfigWebApplicationContext();
		
		applicationConfig.register(ApplicationConfig.class);
		
		
		
		// Listener
		servletContext.addListener(new ContextLoaderListener(applicationConfig));
		
		
		
		// ServletConfig
		AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
		
		servletConfig.register(ServletConfig.class);
		
		// servlet을 동적으로 등록하는데 dispatcherServlet이라는 이름을 가지고.new DispatcherServlet(servletConfig) 얘를.
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("*.do");
		
		
		// EncodingFilter
		FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");

	}

}
