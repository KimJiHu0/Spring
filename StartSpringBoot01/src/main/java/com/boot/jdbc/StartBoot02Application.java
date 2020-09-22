package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class StartBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot02Application.class, args);
	}
	
	// 처음 프로젝트 실행했을 때 가장 처음 index.jsp 실행되게 return해줌
	// 처음으로 /로 들어오게 되면 해당 method를 실행해준 후 return index.jsp를 띄어주라고 해서
	// 가장 처음에 index.jsp가 띄어진다.
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
