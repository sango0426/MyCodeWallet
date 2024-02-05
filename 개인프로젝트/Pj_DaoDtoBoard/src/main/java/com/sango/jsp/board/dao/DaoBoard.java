package com.sango.jsp.board.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.sango.db.DaoDb;
import com.sango.db.Db;
import com.sango.jsp.board.Board;
import com.sango.jsp.board.dto.Dto;

public class DaoBoard extends DaoDb {
	
	/* 삭제 */
	public void del(String num, String category) {
		super.connect();
		String sql = String.format("DELETE FROM %s WHERE B_NUM = %s AND B_CATEGORY = %s", Board.TABLE_TARKOV_BOARD, num, category);
		super.update(sql);
		super.close();
	}
	
	/* 쓰기 */
	public void write(String category, String title, String text) {
		super.connect();
		String sql = String.format("INSERT INTO %s (B_CATEGORY, B_TITLE, B_TEXT) VALUES ('%s', '%s', '%s')",
				Board.TABLE_TARKOV_BOARD, category, title, text);
		super.update(sql);
		super.close();
	}
	
	
	/* 읽기 */
	public Dto selectPost(String category, String num, String id) {
		super.connect();
		Dto post = null;
		try {
			String sql = String.format("SELECT FROM %s WHERE B_ID = %s", Board.TABLE_TARKOV_BOARD, id);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			String userNickname = rs.getString("B_NICKNAME");
			sql = String.format("SELECT B_CATEGORY, B_NUM, B_TITLE, %s, B_DATETIME, B_HIT, B_TEXT, B_REPLY_COUNT, B_REPLY_ORI FROM %s WHERE B_NUM = %s, B_CATEGORY LIKE '%s'",
					userNickname, Board.TABLE_TARKOV_BOARD, num, category);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	
	
	/* 수정 */
	public void edit(String title, String text) {
		
	}
	
	
	/* 로그인 */
	public void login(String nickname, String id, String pw) {
		
	}
	
	
	/* 회원가입 */
	
	
	
	/* 글 리스트 */
	
	
	
	/* 총 글 수 구하기 */
	
	
	
	/* 총 글 수 구하기<검색> */
	
	
	
	/* 글 리스트<검색> */
	
	
}
