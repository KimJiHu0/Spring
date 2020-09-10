package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

// repository라는걸 의미하는 어노테이션
@Repository
public class BoardDaoImpl implements BoardDao {

	// sqlSession과 연결해주는 어노테이션이라고 할 수 있다.
	// 값을 그 SqlSession을 사용하려면 factory가 필요하고 이를 만들려면 factorybuilder이 필요한데
	// applicationContext.xml에서 이를 만들어줬기 때문에 변수로 선언해주기만하면 되고 그 값을
	// 가져와서 담아주기만 하면 된다.
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
			res = sqlSession.insert(NAMESPACE + "insert", dto);
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
			res = sqlSession.update(NAMESPACE + "update", dto);
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
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			System.out.println("[error] delete");
			e.printStackTrace();
		}
		return res;
	}

}
