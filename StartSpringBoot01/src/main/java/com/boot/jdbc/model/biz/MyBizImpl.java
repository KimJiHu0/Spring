package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.jdbc.model.dto.MyDto;
import com.boot.jdbc.model.mapper.MyboardMapper;

@Service
public class MyBizImpl implements MyBiz {

	@Autowired
	private MyboardMapper myboardmapper;
	
	@Override
	public List<MyDto> selectList() {
		return myboardmapper.selectList();
	}

	@Override
	public MyDto selectOne(int myno) {
		return myboardmapper.selectOne(myno);
	}

	@Override
	public int insert(MyDto dto) {
		return myboardmapper.insert(dto);
	}

	@Override
	public int update(MyDto dto) {
		return myboardmapper.update(dto);
	}

	@Override
	public int delete(int myno) {
		return myboardmapper.delete(myno);
	}

}
