package com.mvc.spring.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring.model.dao.BoardDao;
import com.mvc.spring.model.dto.BoardDto;

// 해당 class는 Service라는 것을 명시해주는 Annotation이다.
@Service
public class BoardBizImpl implements BoardBiz {
	
	// BoardDao interface를 import해주고 전역변수로 선언고 @Autowired를 걸어주면
	// SpringMVC흐름도에 맞게 controller -> service -> repositroy -> service -> controller 처럼 연결해주는 거라고 생각하면 된다.
	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

}
