package com.peisia.jsp.board.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.peisia.db.Dao;
import com.peisia.jsp.board.Board;
import com.peisia.jsp.board.dto.Dto;

public class DaoBoard extends Dao {

	// (1/5) 글 삭제
	public void del(String category, String no) {
		super.connect(); // DB 연결
		String sql = String.format("delete from %s where b_no=%s and b_category like '%s'", Board.TABLE_PS_BOARD_FREE,
				no, category);
		super.update(sql); // SQL 실행
		super.close(); // DB 연결 해제
	}

	// (2/5) 글 쓰기
	public void insert(Dto d) {
		super.connect(); // DB 연결
		String sql = String.format("insert into %s (b_category,b_title,b_id,b_text) values ('%s','%s','%s','%s')",
				Board.TABLE_PS_BOARD_FREE, d.category, d.title, d.id, d.text);
		super.update(sql); // SQL 실행
		super.close(); // DB 연결 해제
	}

	// (3/5) 글 읽기
	public Dto selectPost(String category, String no) {
		super.connect(); // DB 연결
		Dto post = null;
		try {
			String sql = String.format(
					"select b_category,b_no,b_title,b_id,b_datetime,b_hit,b_text,b_reply_count,b_reply_ori from %s where b_no=%s and b_category like '%s'",
					Board.TABLE_PS_BOARD_FREE, no, category);
			ResultSet rs = st.executeQuery(sql); // SQL 실행 및 결과 가져오기
			rs.next();
			// 결과를 Dto 객체로 매핑
			post = new Dto(category, rs.getString("B_NO"), rs.getString("B_TITLE"), rs.getString("B_ID"),
					rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close(); // DB 연결 해제
		return post;
	}

	// (4/5) 글 리스트
	public ArrayList<Dto> selectList(String category, int startIndex) {
		super.connect(); // DB 연결
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format("select * from %s where b_category like '%s' limit %d,%d",
					Board.TABLE_PS_BOARD_FREE, category, startIndex, Board.LIST_AMOUNT);
			ResultSet rs = st.executeQuery(sql); // SQL 실행 및 결과 가져오기
			// 결과를 ArrayList에 매핑
			while (rs.next()) {
				posts.add(new Dto(rs.getString("B_CATEGORY"), rs.getString("B_NO"), rs.getString("B_TITLE"),
						rs.getString("B_ID"), rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close(); // DB 연결 해제
		return posts;
	}

	// (5/5) 글 수정
	public void update(Dto d, String no) {
		super.connect(); // DB 연결
		String sql = String.format("update %s set b_title='%s',b_text='%s' where b_no=%s", Board.TABLE_PS_BOARD_FREE,
				d.title, d.text, no);
		super.update(sql); // SQL 실행
		super.close(); // DB 연결 해제
	}

	// 총 글 수 구하기
	public int selectPostCount(String category) {
		int count = 0;
		super.connect(); // DB 연결
		try {
			String sql = String.format("select count(*) from %s where b_category like '%s'", Board.TABLE_PS_BOARD_FREE,
					category);
			ResultSet rs = st.executeQuery(sql); // SQL 실행 및 결과 가져오기
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close(); // DB 연결 해제
		return count;
	}

	// 검색된 글 수 구하기
	public int selectSearchPostCount(String category, String word) {
		int count = 0;
		super.connect(); // DB 연결
		try {
			String sql = String.format("select count(*) from %s where b_title like '%%%s%%' and b_category like '%s'",
					Board.TABLE_PS_BOARD_FREE, word, category);
			ResultSet rs = st.executeQuery(sql); // SQL 실행 및 결과 가져오기
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close(); // DB 연결 해제
		return count;
	}

	// 검색된 글 리스트
	public ArrayList<Dto> selectList(String category, int startIndex, String word) {
		super.connect(); // DB 연결
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format(
					"select b_category,b_no,b_title,b_id,b_datetime,b_hit,b_text,b_reply_count,b_reply_ori from %s where b_title like '%%%s%%' and b_category like '%s' limit %s,%s",
					Board.TABLE_PS_BOARD_FREE, word, category, startIndex, Board.LIST_AMOUNT);
			ResultSet rs = st.executeQuery(sql); // SQL 실행 및 결과 가져오기
			// 결과를 ArrayList에 매핑
			while (rs.next()) {
				posts.add(new Dto(rs.getString("B_CATEGORY"), rs.getString("B_NO"), rs.getString("B_TITLE"),
						rs.getString("B_ID"), rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close(); // DB 연결 해제
		return posts;
	}
}
