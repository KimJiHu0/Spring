package com.mvc.spring.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring.model.dao.MemberDao;
import com.mvc.spring.model.dto.MemberDto;

// Service Class라는 것을 알려주는 Annotation
@Service
public class MemberBizImpl implements MemberBiz {

	// @Repository와 연결해주는 것을 의미하는 Annotation
	@Autowired
	private MemberDao dao;
	
	@Override
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public int insertMember(MemberDto dto) {
		return dao.insertMember(dto);
	}

}
