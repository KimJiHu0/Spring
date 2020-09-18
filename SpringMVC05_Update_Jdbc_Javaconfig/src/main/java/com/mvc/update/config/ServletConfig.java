package com.mvc.update.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


// servlet-context.xml -> java File

// WebMvcCongifurer을 implements 해준다.
@Configuration // = config file 이라는 걸 알려주는 annotation
@EnableWebMvc // = @Controller, @Serviec, @Respository 등을 만들어주는 <annotation-driven /> 역할
@ComponentScan("com.mvc.update") // = <context:component-scan base-package="com.mvc.update" /> 역할
public class ServletConfig implements WebMvcConfigurer {

	// <resources mapping="/resources/**" location="/resources/" /> 역할
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// mapping => addResourceHandler("/resources/**")
		// location => addResourceLocations("/resources/")
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	// InternalResourceViewResolver 만들어주기
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		return new InternalResourceViewResolver(prefix, suffix);
	}
	
}
