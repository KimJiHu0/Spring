package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class StartBoot0201Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot0201Application.class, args);
	}
	
	
	// 이거 작성 안해주면 404뜸
	// 가장 최상위인 / 를 지정해주면 프로젝트 실행 후 
	// index를 가장 먼저 return 한다.
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
