package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dao.BoardDaoImpl;
import com.mvc.upgrade.model.dto.BoardDto;

// 해당 클래스가 service로직을 담당하는 애야.
@Service
public class BoardBizImpl implements BoardBiz {

	//BoardDao dao = new BoardDaoImpl();
	
	// dao에 repository를 걸어줘서 그거랑 연결이 될거임.
	@Autowired
	private BoardDao dao;
	
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		return dao.delete(myno);
	}

}
