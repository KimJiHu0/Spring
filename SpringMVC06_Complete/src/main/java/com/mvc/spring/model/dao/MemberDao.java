package com.mvc.spring.model.dao;

import com.mvc.spring.model.dto.MemberDto;

public interface MemberDao {
	
	String NAMESPACE="mymember.";
	
	public MemberDto signin(MemberDto dto);
	public int signup(MemberDto dto);

}
