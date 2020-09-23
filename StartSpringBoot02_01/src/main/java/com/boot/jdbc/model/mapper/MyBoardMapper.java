package com.boot.jdbc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.jdbc.model.dto.MyBoardDto;

@Mapper // : mapper라고 알려주는 Annotation
public interface MyBoardMapper {
	
	// Mapper과 Dao를 한번에 만들었다.
	// 이렇게만 작성해주면 다른거 필요없다.
	
	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD ORDER BY MYNO DESC ")
	List<MyBoardDto> selectList();
	
	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD WHERE MYNO = #{myno} ORDER BY MYNO DESC ")
	MyBoardDto selectOne(int myno);
	
	@Insert(" INSERT INTO MYBOARD VALUES(MYBOARDSEQ.NEXTVAL, #{myname}, #{mytitle}, #{mycontent}, SYSDATE ) ")
	int insert(MyBoardDto dto);
	
	@Update(" UPDATE MYBOARD SET MYTITLE = #{mytitle}, MYCONTENT= #{mycontent} WHERE MYNO = #{myno} ")
	int update(MyBoardDto dto);
	
	@Delete(" DELETE FROM MYBOARD WHERE MYNO = #{myno} ")
	int delete(int myno);

}
