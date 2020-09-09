package com.mvc.spring.model.dao;

import com.mvc.spring.model.dto.MemberDto;

public interface MemberDao {
	
	String NAMESPACE = "member.";
	
	// 로그인 하는 메소드
	public MemberDto login(MemberDto dto);

}
