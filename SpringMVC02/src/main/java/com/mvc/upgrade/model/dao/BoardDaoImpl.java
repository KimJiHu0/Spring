package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

// 해당 class는 repository라고 알아들어.
// dao라고 알아듣는다는거야.
// @controller에서 @Service -> @repository로 넘어갈거야.
@Repository
public class BoardDaoImpl implements BoardDao {
	
	// 
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardDto> selectList() {
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			System.out.println("[error] selectList");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = new BoardDto();
		
		System.out.println("dao : " + myno);
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
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
			res = sqlSession.insert(NAMESPACE + "insertList", dto);
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
			res = sqlSession.update(NAMESPACE+"updateList", dto);
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
			res = sqlSession.delete(NAMESPACE + "deleteList", myno);
		} catch (Exception e) {
			System.out.println("[error] delete");
			e.printStackTrace();
		}
		return res;
	}

}
