package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	// 얘는 repository라는 객체가 만들어지고 db와 연결되어서 값을 가져올거야.
	// 그래서 얘는 sqlSession을 autowired해준거야
	// sqlSession을 쓰려면 sqlSessionFactory가 필요하고 이를 생성하려면
	// sqlSessionFactoryBulider가 필요한데 이 설정을 applicationContext.xml에서
	// sqlsessionTemplate에서 다 해줄거야. 그걸 가져와서
	// sqlSession을 사용하면 돼.
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
			res = sqlSession.update(NAMESPACE + "updateList", dto);
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
