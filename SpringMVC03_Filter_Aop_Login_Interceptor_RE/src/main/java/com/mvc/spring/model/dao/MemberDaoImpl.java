package com.mvc.spring.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.spring.model.dto.MemberDto;

// Repository Class라는 것을 의미하는 Annotation
@Repository
public class MemberDaoImpl implements MemberDao {

	// mapper를 사용할 수 있도록 연결해주는 sqlSession을 전역변수로 선언하고 Autowired를 걸어주어서
	// 연결해준 것을 의미한다.
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// MemberDaoImpl Class에서 System.out.println() 대신에 Logger를 찍기 위해 선언해준 전역변수.
	private Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Override
	public MemberDto login(MemberDto dto) {
		
		MemberDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "login", dto);
		} catch (Exception e) {
			logger.info("[error] login");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertMember(MemberDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insertmember", dto);
		} catch (Exception e) {
			logger.info("[ error ] insert");
			e.printStackTrace();
		}
		return res;
	}

}
