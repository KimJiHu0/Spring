package com.hello.mvc.model.dao;

import org.springframework.stereotype.Repository;

// 자동으로 dao로 잡아줘
@Repository
public class HelloDao {
	
	// TODO : 07. Dao에서 return
	public String getHello() {
		
		
		
		return "Spring";
	}

}
