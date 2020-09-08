package com.mvc.spring.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.spring.model.dto.BoardDto;

// 해당 class는 repository라는 것을 명시해주는 Annotation이다.
@Repository
public class BoardDaoImpl implements BoardDao {

	// sqlSession은 내부에서 Fcatory가 만들어져있어서 db에서 값을 편하게 가져오기 위해.
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	@Override
	public List<BoardDto> selectList() {
			List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list = sqlsession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			System.out.println("[error] list");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = new BoardDto();
		
		try {
			dto = sqlsession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			System.out.println("[error] selectOne");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlsession.insert(NAMESPACE + "insertDto", dto);
		} catch (Exception e) {
			System.out.println("[error] insert");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		
		int res = 0;
		
		try {
			res = sqlsession.update(NAMESPACE + "updateDto", dto);
		} catch (Exception e) {
			System.out.println("[error] update");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlsession.delete(NAMESPACE + "deleteOne", myno);
		} catch (Exception e) {
			System.out.println("[error] delete");
			e.printStackTrace();
		}
		return res;
	}

}
