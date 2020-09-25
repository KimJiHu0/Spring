package com.mvc.spring.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring.model.dao.MemberDao;
import com.mvc.spring.model.dto.MemberDto;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDao dao;
	
	@Override
	public MemberDto signin(MemberDto dto) {
		return dao.signin(dto);
	}

	@Override
	public int signup(MemberDto dto) {
		return dao.signup(dto);
	}

}
