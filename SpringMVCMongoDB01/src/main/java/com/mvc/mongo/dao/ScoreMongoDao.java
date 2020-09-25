package com.mvc.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.mongo.dto.ScoreMongoDto;

@Repository
public class ScoreMongoDao {

	// 우리가 mongodb-context.xml 에서 만들어준 객체 선언
	@Autowired
	private MongoTemplate mongo;
	
	public List<ScoreMongoDto> findAll(){
		
		// 현재 이미 test라는 database라 연결이 되어있음.
		// 그 안에 "score"라는 collection를 찾아서 findAll해줄건데
		// ScoreMongoDto Class Type의 객체를 만들어 담아서
		// 이걸 list에 담아서 return
		List<ScoreMongoDto> list = mongo.findAll(ScoreMongoDto.class, "score");
		
		
		return list;
	}
	
}
