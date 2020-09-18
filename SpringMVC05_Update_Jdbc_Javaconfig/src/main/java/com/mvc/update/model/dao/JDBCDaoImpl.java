package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	
	
	@Override
	public List<JDBCDto> selectList() {
		
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";
		
		try {
			// lambda식으로 작성하기
			list = jdbctemplate.query(sql, (rs, rowNum)->{
				return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			});
		} catch (DataAccessException e) {
			System.out.println("[ error ] selectList");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public JDBCDto selectOne(int seq) {
		
		JDBCDto dto = new JDBCDto();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REDATE FROM JDBCBOARD WHERE SEQ = ? ";
		
		// seq값을 Object[]로 만들어서 던져준다.
		// sql문 where절에 seq를 넣어준다.
		dto = jdbctemplate.queryForObject(sql, new Object[] {seq}, new MyMapper());
		return dto;
	}

	@Override
	public int insert(JDBCDto dto) {
		
		int res = 0;
		
		String sql = " INSERT INTO JDBCBOARD VALUES( JDBCSEQ.NEXTVAL, ?, ?, ?, SYSDATE ) ";
		return 0;
	}

	@Override
	public int update(JDBCDto dto) {
		
		int res = 0;
		
		String sql = " UPDATE JDBCBOAORD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
		return 0;
	}

	@Override
	public int delete(int seq) {
		
		int res = 0;
		
		String sql = " DELETE FROM JDBCBOARD WHERE SEQ = ? ";
		return 0;
	}
	
	
	// inner Class : class 안에 class
	private static final class MyMapper implements RowMapper<JDBCDto>{

		@Override
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			// 여기서 ResultSet rs 안에있는 한줄한줄이 list로 넘어가서
			// rs가 여러개 모여서 list가 완성되는 것
			// return결과물을 selectList에 가져가는데 지금은
			// selectOne에서 rs하나를 가지고 온다.
			return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
	}

}
