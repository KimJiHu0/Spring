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
		logger.info(" \n [ Dao : selectList ]");
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			logger.info("[ error ] selectList");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		logger.info(" \n [ Dao : selectOne ] ");
		BoardDto dto = new BoardDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			logger.info("[ error ] selectOne");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		logger.info(" \n [ Dao : insert ]");
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			logger.info("[ error ] insert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		logger.info(" \n [ Dao : update ]");
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			logger.info(" [ error ] update ");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		logger.info("\n [ Dao : delete ]");
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			logger.info("[ error ] delete");
			e.printStackTrace();
		}
		return res;
	}

}
