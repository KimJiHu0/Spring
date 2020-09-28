package com.mvc.spring.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.spring.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	private Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectList() {
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			logger.info("selectList에서 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int boardno) {
		
		BoardDto dto = new BoardDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", boardno);
		} catch (Exception e) {
			logger.info("selectOne에서 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			logger.info("insert에서 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		
		int res = 0; 
		
		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			logger.info("update에서 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int boardno) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", boardno);
		} catch (Exception e) {
			logger.info("delete에서 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return res;
	}

}
