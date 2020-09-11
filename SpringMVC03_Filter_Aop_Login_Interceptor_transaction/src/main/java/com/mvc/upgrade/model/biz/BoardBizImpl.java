package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {

	
	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	// 트랜잭션이라는 걸 의미하는 annotation
	// 얘를 걸어줘야지 여러개의 dao중에서 하나라도 실패하면 rollback이 될거고
	// 하나라도 성공하면 전부 성공하게끔 만들어준다.
	// 말그래돌 트랜잭션의 특성을 지정?해준다.
	@Transactional
	@Override
	public String transactionTest() {
		// 메소드가 실행된다면 insnert가 되고
		dao.insert(new BoardDto(0, "transaction", "test", "insert", null));
		
		// test라는 변수에 dao에서 test라는 함수를 실행한 결과값을 담았는데
		// test는 현재 null이다 그래서 에러가 난다.
		// 하지만 insert는 그대로 실행이 된다.
		// transaction은 하나가 실행이 안된다면 전부 안되고 하나가 실행이 되면 전부 다 실행되야한다.
		// 그래서 rollback을 해줘야한다.[ 얘는 rollback안됌 ]
		String test = dao.test(); 
		// NullPointer 발생
		test.length();
		
		return test;
	}

}
