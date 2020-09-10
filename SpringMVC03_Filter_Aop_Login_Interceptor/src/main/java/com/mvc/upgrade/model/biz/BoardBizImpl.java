package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

// service라는걸 의미하는 어노테이션
@Service
public class BoardBizImpl implements BoardBiz {

	// repository와 연결해주는 어노테이션이라고 볼 수 있다.
	// controller에서 service로, respoitory로 갔다가 다시 service로 보낼 때 값을 가져올 수 있게
	// 결과값을 자동으로 채워주는 어노테이션이다.
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
