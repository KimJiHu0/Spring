package com.mvc.spring.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.spring.model.dto.BoardDto;

// BoardDao는 Repository라는걸 알려주는 Annotation이라고 할 수 있다.
@Repository
public class BoardDaoImpl implements BoardDao {

	// sqlSession은 내부에서 SqlSessionFactory가 만들어져 있고 db에서 값을 가져올 수 있기 때문에
	// autowired를 걸어준 후에 db에서 값을 가져와서 편하게 쓸 수 있게끔 만들어줬다.
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// System.out.println 대신 찍어주기 위해 전역변수로 선언해주었다.
	private Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			logger.info("[error] selectList");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		
		BoardDto dto = new BoardDto();
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			logger.info("[error] detailList");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insertList", dto);
		} catch (Exception e) {
			logger.info("[error] insertList");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE + "updateList", dto);
		} catch (Exception e) {
			logger.info("[error] update");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "deleteList", myno);
		} catch (Exception e) {
			logger.info("[error] delete");
			e.printStackTrace();
		}
		return res;
	}

	
	// 고의로 에러를 유발하기 위한 메소드
	@Override
	public String test() {
		
		return null;
	}

}
