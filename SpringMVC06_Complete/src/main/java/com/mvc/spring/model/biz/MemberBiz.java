package com.mvc.spring.model.biz;

import com.mvc.spring.model.dto.MemberDto;

public interface MemberBiz {
	
	public MemberDto signin(MemberDto dto);
	public int signup(MemberDto dto);

}
