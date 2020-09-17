package com.mvc.update.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public List<JDBCDto> selectList() {
		
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		
		// sql문이랑 rowmapper를 넣으면 List를 반환
		//list = jdbctemplate.query(SELECTLIST, new MyMapper());
		
		//lambda : java 1.8 버전 이상부터 가능
		list = jdbctemplate.query(SELECTLIST, (rs,rowNum)->{
			JDBCDto dto = new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
					return dto;
		});
		
		
		return list;
	}

	@Override
	public JDBCDto selectOne(int seq) {
		
		JDBCDto dto = new JDBCDto();
		
		// seq 값 Object[] 로 만들어서 던져주겠다. sql문에 where절에
		dto = jdbctemplate.queryForObject(SELECTONE, new Object[]{seq}, new MyMapper());
		
		return dto;
	}

	@Override
	public int insert(JDBCDto dto) {
		
		int res = 0;
		
		// update하는 이유는 jdbc에서 executeUpdate를 해줬었는데 이 때문에 insert, update, delete 전부 update로 해준다.
		res = jdbctemplate.update(INSERT, dto.getWriter(), dto.getTitle(), dto.getContent());
		
		return res;
	}

	@Override
	public int update(JDBCDto dto) {
		
		int res = 0;
		
		res = jdbctemplate.update(UPDATE, dto.getTitle(), dto.getContent(), dto.getSeq());
		
		return res;
	}

	@Override
	public int delete(int seq) {
		
		int res = 0;
		
		res = jdbctemplate.update(DELETE, seq);
		
		return res;
	}
	
	
	// inner Class : class 안에 class
	private static final class MyMapper implements RowMapper<JDBCDto>{

		@Override
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			// 해당 ResultSet 안에있는 한줄한줄이 list로 넘어가서 List에서 return해준다.
			// 여기서 ResultSet return 결과물을 selectList에서 가져와서 사용한다.
			// ReesultSet에 미리 준비를 해둔거다.
			return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
	}

}
