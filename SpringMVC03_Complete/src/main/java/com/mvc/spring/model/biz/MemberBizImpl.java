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
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}


	@Override
	public int regist(MemberDto dto) {
		return dao.regist(dto);
	}

}
