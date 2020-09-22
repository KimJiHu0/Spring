package com.mvc.spring.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.spring.model.dto.MemberDto;

@Repository
public class MemberDaoImp implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberDto login(MemberDto dto) {
		
		MemberDto res = null;
		
		res = sqlSession.selectOne(NAMESPACE + "login", dto);
		
		return res;
	}

	@Override
	public int regist(MemberDto dto) {
		
		int res = 0;
		
		res = sqlSession.insert(NAMESPACE + "regist", dto);
		
		return res;
	}

}
