package com.mvc.spring.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.spring.model.dao.BoardDao;
import com.mvc.spring.model.dto.BoardDto;

// Service이라는걸 알려주는 Annotation이라고 할 수 있다.
@Service
public class BoardBizImp implements BoardBiz {
	
	// @Repository인 BoardDao와 연결해주는 Annotation이라고 할 수 있다.
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

	
	// 트랜잭션을 사용하는 이유는 여러개의 dao를 한번에 처리할 일이 있다면 이를 처리하기 위해서 사용한다.
	// Transactional Annotation을 걸어주게 되면 이 메소드는 트랜잭션이라는 것을 의미한다.
	// 트랜잭션의 특성 중 하나는 여러개의 dao 처리 중에서 하나라도 실패하면
	// 모두 실패하고, 하나라도 성공하면 모두 성공하게 되야하며
	// 하나가 실패했다면 rollback이 되야한다.
	// 이 Annotation을 걸어주지 않으면 rollback이 되지 않아서 오류는 나지만 insert가 되는 상황이
	// 발생한다.
	// 이를 걸어주기 위해서는 servlet-context에서 Annotation을 생성하는 태그를 만들어주고
	// application에서는 Transaction Setting을 해줘야 한다.
	@Override
	@Transactional
	public String transactionTest() {
		// 메소드가 실행된다면 insert가 될 것이다.
		dao.insert(new BoardDto(0, "Transaction", "Test", "Insert", null));
		
		// test라는 String 변수에 BoardDao dao의 메소드 test의 실행 결과를 담았다.
		// dao의 test의 return은 null이다. 그럼 test라는 변수에 null이 들어갈거고
		String test = dao.test();
		
		// null의 길이를 찾으려 하고 이를 return 하려고 하니까 오류가 난다.
		// 이 때 트랜잭션은 하나의 연산이 실패하면 모든 연산이 실패해야하고,
		// 하나의 연산이 성공하면 모든 연산이 성공해야한다.
		// 하지만 이렇게 하고 실행할 경우 오류는 뜨지만 insert는 되는 것을 볼 수 있다.
		test.length();
		
		return test;
	}

}
