package com.mvc.spring.model.dao;


import com.mvc.spring.model.dto.MemberDto;

public interface MemberDao {
	
	String NAMESPACE = "mymember.";
	
	public MemberDto login(MemberDto dto);
	public int regist(MemberDto dto);

}
