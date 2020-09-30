package com.mvc.spring.model.biz;

import java.util.List;

import com.mvc.spring.model.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int boardno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int boardno);

}
