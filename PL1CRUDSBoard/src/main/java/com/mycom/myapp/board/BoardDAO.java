package com.mycom.myapp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

//	private final String BOARD_INSERT = "insert into BOARD (title, category, writer, content) values (?,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set title=?, category=?, writer=?, content=? where seq=?";
//	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
//	private final String BOARD_GET = "select * from BOARD  where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		String sql = "insert into BOARD (title, category, writer, content) values ("
		+ "'" + vo.getTitle() + "',"
		+ "'" + vo.getCategory() + "',"
		+ "'" + vo.getWriter() + "',"
		+ "'" + vo.getContent() + "')";
		
		return jdbcTemplate.update(sql);
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		String sql = "delete from BOARD where seq = " + seq;
		return jdbcTemplate.update(sql);
	}
	
	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set title='" + vo.getTitle() + "',"
				+ " category='" + vo.getCategory() + "',"
				+ " writer='" + vo.getWriter() + "',"
				+ " content='" + vo.getContent() + "' where seq=" + vo.getSeq();
		return jdbcTemplate.update(sql);
	}	
	
	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where seq=" + seq;
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(){
		String sql = "select * from BOARD order by regdate desc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}
