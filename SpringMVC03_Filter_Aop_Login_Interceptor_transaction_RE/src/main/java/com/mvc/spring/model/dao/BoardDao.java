package com.mvc.spring.model.dao;

import java.util.List;

import com.mvc.spring.model.dto.BoardDto;

public interface BoardDao {
	
	String NAMESPACE = "com.mvc.spring.myboard.";
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
	
	// 고의로 에러를 유발하기 위한 메소드
	public String test();

}
