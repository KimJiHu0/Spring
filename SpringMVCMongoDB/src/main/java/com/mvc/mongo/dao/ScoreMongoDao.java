package com.mvc.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.mongo.dto.ScoreMongoDto;

@Repository
public class ScoreMongoDao {

	@Autowired
	private MongoTemplate mongotemplate;
	
	public List<ScoreMongoDto> findAll(){
		
		// "score"라는 collection을 찾아서 findAll해줄건데, ScoreMongoDtoClassType의 객체를 만들어서
		// 값을 넣어서 return.
		List<ScoreMongoDto> list = mongotemplate.findAll(ScoreMongoDto.class, "score");
		
		return list;
	}
	
}
