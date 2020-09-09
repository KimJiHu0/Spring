package com.mvc.spring.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring.model.dao.BoardDao;
import com.mvc.spring.model.dto.BoardDto;

// Service이라는걸 알려주는 Annotation이라고 할 수 있다.
@Service
public class BoardBizImp implements BoardBiz {
	
	// @Repository인 BoardDao와 연결해주는 Annotation이라고 할 수 있다.
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
