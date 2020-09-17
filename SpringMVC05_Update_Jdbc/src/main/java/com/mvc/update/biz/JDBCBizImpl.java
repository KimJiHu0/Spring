package com.mvc.update.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.update.dao.JDBCDao;
import com.mvc.update.dto.JDBCDto;

@Service
public class JDBCBizImpl implements JDBCBiz {

	@Autowired
	private JDBCDao dao;
	
	@Override
	public List<JDBCDto> selectList() {
		return dao.selectList();
	}

	@Override
	public JDBCDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(JDBCDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(JDBCDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

}
