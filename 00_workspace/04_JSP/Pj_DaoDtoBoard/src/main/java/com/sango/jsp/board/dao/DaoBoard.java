package com.sango.jsp.board.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import com.sango.c.util.Cw;
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
	public void insert(Dto d) {
		super.connect();
		String sql = String.format("INSERT INTO %s (B_CATEGORY, B_TITLE, B_TEXT) VALUES ('%s', '%s', '%s')",
				Board.TABLE_TARKOV_BOARD, d.category, d.title, d.text);
		super.update(sql);
		super.close();
	}
	
	
	/* 읽기 */
	public Dto selectPost(String category, String num) {
		super.connect();
		Dto post = null;
		try {
			String sql = String.format("SELECT B_CATEGORY, B_NUM, B_TITLE, B_NICKNAME, B_DATETIME, B_HIT, B_TEXT, B_REPLY_COUNT, B_REPLY_ORI FROM %s WHERE B_NUM = %s, B_CATEGORY LIKE '%s'",
					Board.TABLE_TARKOV_BOARD, num, category);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			
			// 결과를 Dto 객체로 매핑
			post = new Dto(category, rs.getString("B_NUM"), rs.getString("B_TITLE"), rs.getString("B_NICKNAME"),
					rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		super.close();
		return post;
	}
	
	
	/* 수정 */
	public void update(Dto d, String num) {
		super.connect();
		String sql = String.format("UPDATE %s SET B_TITLE = '%s', B_TEXT = '%s' WHERE B_NUM = %s",
				Board.TABLE_TARKOV_BOARD, d.title, d.text, d.num);
		super.update(sql);
		super.close();
	}
	
	
	/* 로그인 */
	public HashMap<String, String> login(Dto d) {
		super.connect();
		HashMap<String, String> userInfo = new HashMap<>();
		try {
			String sql = String.format("SELECT * FROM %s WHERE B_ID = %s", Board.TABLE_TARKOV_MEMBER, d.id);
			ResultSet rs = st.executeQuery(sql); 
			if (rs.next()) {
				String userNickname = rs.getString("B_NICKNAME");
                String userId = rs.getString("B_ID");
                String userPw = rs.getString("B_PW");
                
                if(d.id.equals(userId) && d.pw.equals(userPw)) {
                	// 로그인 성공
                    userInfo.put("id", userId);
                    userInfo.put("pw", userPw);
                    userInfo.put("nickname", userNickname);
                }
            } else {
                // 아이디 미존재
                Cw.wn("아이디가 일치하지 않습니다.");
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		super.close();
		return userInfo;
	}
	
	
	/* 회원가입 */
	public void join(String nickname, String id, String pw) {
		super.connect();
		String sql = String.format("INSERT INTO %s (B_NICKNAME, B_ID, B_PW) VALUES ('%s', '%s', '%s')",
					Board.TABLE_TARKOV_MEMBER, nickname, id, pw);
		super.update(sql);
		
		super.close();
	}
	
	
	/* 글 리스트 */
	public ArrayList<Dto> selectList(String category, int startIndex) {
		super.connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format("SELECT * FROM %s WHERE B_CATEGORY LIKE '%s' LIMIT %d, %d",
					Board.TABLE_TARKOV_BOARD, category, startIndex, Board.LIST_AMOUNT);
			// SQL 실행 및 결과 가져오기
			ResultSet rs = st.executeQuery(sql);
			// 결과를 ArrayList에 매핑
			while(rs.next()) {
				posts.add(new Dto(rs.getString("B_CATEGORY"), rs.getString("B_NUM"), rs.getString("B_TITLE"),
						rs.getString("B_NICKNAME"), rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	
	
	/* 총 글 수 구하기 */
	public int selectPostCount(String category) {
		int count = 0;
		super.connect();
		try {
			String sql = String.format("SELECT COUNT(*) FROM %s WHERE B_CATEGORY LIKE '%s'", Board.TABLE_TARKOV_BOARD, category);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("COUNT(*)");
		} catch(Exception e) {
			e.printStackTrace();
		}
		super.close();
		return count;
	}
	
	
	/* 총 글 수 구하기<검색> */
	public int selectSearchPostCount(String category, String word) {
		int count = 0;
		super.connect();
		try {
			String sql = String.format("SELECT COUNT(*) FORM %s WHERE B_TITLE LIKE '%%%s%%' AND B_CATEGORY LIKE '%s'",
					Board.TABLE_TARKOV_BOARD, word, category);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("COUNT(*)");
		} catch(Exception e) {
			e.printStackTrace();
		}
		super.close();
		return count;
	}
	
	
	/* 글 리스트<검색> */
	public ArrayList<Dto> selectList(String category, int startIndex, String word) {
		super.connect();
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			String sql = String.format("SELECT B_CATEGORY, B_NUM, B_TITLE, B_NICKNAME, B_DATETIME, B_HIT, B_TEXT, B_REPLY_COUNT, B_REPLY_ORI FROM %s WHERE B_TITLE LIKE '%%%s%%' AND B_CATEGORY LIKE '%s' LIMIT %s, %s",
					Board.TABLE_TARKOV_BOARD, word, category, startIndex, Board.LIST_AMOUNT);
			// SQL 실행 및 결과 가져오기
			ResultSet rs = st.executeQuery(sql);
			// 결과를 ArrayList에 매핑
			while(rs.next()) {
				posts.add(new Dto(rs.getString("B_CATEGORY"), rs.getString("B_NUM"), rs.getString("B_TITLE"),
						rs.getString("B_NICKNAME"), rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	
}

//	/* 유저 정보 리스트<관리자모드> */
//	public ArrayList<Dto> userIdPw(String id, String pw) {
//		super.connect();
//		ArrayList<Dto> userInfo = new ArrayList<>();
//		try {
//			String sql = String.format("SELECT FROM %s WHERE B_ID = %s, B_PW = %s", Board.TABLE_TARKOV_BOARD, id, pw);
//			ResultSet rs = st.executeQuery(sql);
//			while(rs.next()) {
//				userInfo.add(new Dto(rs.getString("B_NICKNAME"), rs.getString("B_ID"), rs.getString("B_PW")));
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		super.close();
//		return userInfo;
//	}