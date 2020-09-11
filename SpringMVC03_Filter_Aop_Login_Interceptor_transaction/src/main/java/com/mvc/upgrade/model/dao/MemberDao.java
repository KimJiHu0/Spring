package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.MemberDto;

public interface MemberDao {
	
	String NAMESPACE = "mymember.";
	
	// 로그인하는 메소드
	public MemberDto login(MemberDto dto);
	public int regist(MemberDto dto);

}
