package com.mvc.spring.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.spring.model.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlsession;
	
	private Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Override
	public MemberDto signin(MemberDto dto) {
		
		logger.info("[ dao ] signin");
		MemberDto res = null;
		
		try {
			res = sqlsession.selectOne(NAMESPACE + "signin", dto);
		} catch (Exception e) {
			logger.info("[ error ] signin");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int signup(MemberDto dto) {
		
		int res = 0;
		
		try {
			res = sqlsession.insert(NAMESPACE + "signup", dto);
		} catch (Exception e) {
			logger.info("[ error ] signup");
			e.printStackTrace();
		}
		return res;
	}

}
