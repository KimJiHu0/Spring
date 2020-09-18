package com.mvc.update.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// 이 파일이 spring bean config file을 대신하는 java class라는 걸 annotation으로 걸어준다.
// config : Spring에서 IoC역할을 해주고 객체생성을 해준다.
@Configuration
// db.properties가 위치한 경로에서 db.properties를 가져와서 쓰겠다.
@PropertySource("classpath:sqls/db.properties")
public class ApplicationConfig {
	
	// @PropertySource 에서 db.properties에서 가져온 값들을 넣어준다.
	
	@Value("${jdbc.driver}") // = xml에서 value와 동일
	private String driver; // = xml에서 name과 동일
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	
	@Bean // dataSource()가 호출되면 객체가 return되는 bean이라는 걸 의미.
	public DataSource dataSource() {
		
		// DriverManagerDataSource 객체 생성
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		
		// xml에서 property는 setter와 동일하기 때문에 set으로 값을 입력.
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		
		return datasource;
	}
	
	// jdbcTemplate
	@Bean // = 이 메소드는 bean이다 라는 걸 의미.
	public JdbcTemplate jdbcTemplate() {
		// JdbcTemplate는 xml에서 dataSource를 참조하고 있기 때문에
		// Template를 만들 때에 객체 생성 후 괄호 안에 위에서 만든 dataSource를 호출하여 참조해준다.
		return new JdbcTemplate(dataSource());
	}
	

}
