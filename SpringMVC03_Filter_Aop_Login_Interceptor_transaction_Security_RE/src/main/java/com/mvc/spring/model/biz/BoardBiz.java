package com.mvc.spring.model.biz;

import java.util.List;

import com.mvc.spring.model.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
	
	
	// 트랜잭션 처리는 biz에서 해야한다.
	public String transactionTest();

}
