package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.jdbc.model.dto.MyBoardDto;
import com.boot.jdbc.model.mapper.MyBoardMapper;

@Service
public class MyBoardBizImpl implements MyBoardBiz {

	@Autowired
	private MyBoardMapper myboardmapper;
	
	@Override
	public List<MyBoardDto> selectList() {
		return myboardmapper.selectList();
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		return myboardmapper.selectOne(myno);
	}

	@Override
	public int insert(MyBoardDto dto) {
		return myboardmapper.insert(dto);
	}

	@Override
	public int update(MyBoardDto dto) {
		return myboardmapper.update(dto);
	}

	@Override
	public int delete(int myno) {
		return myboardmapper.delete(myno);
	}

}
