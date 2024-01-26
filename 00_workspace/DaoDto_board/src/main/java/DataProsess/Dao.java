package DataProsess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;

public class Dao {
	Connection con = null;
	Statement st = null;

	/* (1/5) 글 삭제 */
	public void del(String num) {
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 글 삭제
			String sql = String.format("delete from %s where B_NUM=%s", Db.TABLE_PS_BOARD_FREE, num);
			st.executeUpdate(sql);

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (2/5) 글 쓰기 */
	public void write(Dto d) {
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 글 쓰기
			String sql = String.format("insert into %s (b_title,b_nickname,b_text) values ('%s','%s','%s')",
					Db.TABLE_PS_BOARD_FREE, d.title, d.nickname, d.text);
			st.executeUpdate(sql);

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (3/5) 글 읽기 */
	public Dto read(String num) {
		Dto post = null;
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 글 읽기
			String sql = String.format("select * from %s where b_num=%s", Db.TABLE_PS_BOARD_FREE, num);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(rs.getString("B_NUM"), rs.getString("B_TITLE"), rs.getString("B_NICKNAME"),
					rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI"));

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}

	/* (4/5) 글 리스트 */
	public ArrayList<Dto> list(String page) {
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();
			int startIndex = ((Integer.parseInt(page)) - 1) * Board.LIST_AMOUNT;

			// SQL 쿼리 실행하여 전체 글 리스트 읽기
			String sql = String.format("select * from %s limit %s, %s",
					Db.TABLE_PS_BOARD_FREE, startIndex, Board.LIST_AMOUNT);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				posts.add(new Dto(rs.getString("B_NUM"), rs.getString("B_TITLE"), rs.getString("B_nickname"),
						rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}

	/* (5/5) 글 수정 */
	public void edit(Dto d, String num) {
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 글 수정
			String sql = String.format("update %s set b_title='%s',b_text='%s' where b_num=%s", Db.TABLE_PS_BOARD_FREE,
					d.title, d.text, num);
			st.executeUpdate(sql);

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (생략) 회원 가입, 로그인, 회원 목록 조회 등의 메서드도 구현되어 있음
	// 중복되는 주석은 생략하고, 새로운 메서드에 대한 주석을 추가해야 함

	/* 회원 가입 */
	public void join(Dto_member d) {
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 회원 가입
			String sql = String.format("insert into %s (b_nickname, b_id, b_pw) values ('%s','%s','%s')",
					Db.TABLE_MEMBER, d.nickname, d.id, d.pw);
			st.executeUpdate(sql);

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 로그인 */
	public Dto_member login(Dto_member d) {
		Dto_member loggedInUser = null;
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 로그인
			String sql = String.format("SELECT * FROM %s where b_id = '%s'", Db.TABLE_MEMBER, d.id);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			loggedInUser = new Dto_member(rs.getString("b_id"), rs.getString("b_pw"), rs.getString("B_nickname"));

			// 로그인 성공 여부 출력
			if (d.id.equals(loggedInUser.id)) {
				if (d.pw.equals(loggedInUser.pw)) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				}
			}

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loggedInUser;
	}

	/* 회원 목록 조회 */
	public ArrayList<Dto_member> members() {
		ArrayList<Dto_member> members = new ArrayList<>();
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 회원 목록 조회
			String sql = String.format("select * from %s", Db.TABLE_MEMBER);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				members.add(new Dto_member(rs.getString("B_ID"), rs.getString("B_PW"), rs.getString("B_nickname")));
			}

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}

	// (생략) 글 수, 페이지 수 관련 메서드도 구현되어 있음
	// 중복되는 주석은 생략하고, 새로운 메서드에 대한 주석을 추가해야 함

	/* 총 글 수 구하기 */
	public int getPostCount() {
		int count = 0;
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 총 글 수 구하기
			String sql = String.format("select count(*) from %s", Db.TABLE_PS_BOARD_FREE);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/* 총 글 수 구하기<검색> */
	public int getSearchPostCount(String word) {
		int count = 0;
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			// SQL 쿼리 실행하여 검색된 글 수 구하기
			String sql = String.format("select count(*) from %s where b_title like '%%%s%%'", Db.TABLE_PS_BOARD_FREE,
					word);
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	/* 글 리스트<검색> */
	public ArrayList<Dto> listSearch(String word, String page) {
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			// JDBC 드라이버 로드
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			// 데이터베이스 연결
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);
			// Statement 객체 생성
			st = con.createStatement();

			int startIndex = ((Integer.parseInt(page)) - 1) * Board.LIST_AMOUNT;

			// SQL 쿼리 실행하여 검색된 글 리스트 읽기
			String sql = String.format("select * from %s where b_title like '%%%s%%' limit %s,%s",
					Db.TABLE_PS_BOARD_FREE, word, startIndex, Board.LIST_AMOUNT);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("b_NUM"));
				posts.add(new Dto(rs.getString("B_Num"), rs.getString("B_TITLE"), rs.getString("B_nickname"),
						rs.getString("B_DATETIME"), rs.getString("B_HIT"), rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"), rs.getString("B_REPLY_ORI")));
			}
			

			// 자원 정리
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}

	/* 총 페이지 수 구하기 */
	public int getTotalPageCount() {
		int totalPageCount = 0;
		int count = getPostCount();

		// 글 수에 따라 페이지 수 계산
		if (count % Board.LIST_AMOUNT == 0) {
			totalPageCount = count / Board.LIST_AMOUNT;
		} else {
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
		
	}

	/* 총 페이지 수 구하기<검색> */
	public int getSearchTotalPageCount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostCount(word);

		// 검색된 글 수에 따라 페이지 수 계산
		if (count % Board.LIST_AMOUNT == 0) {
			totalPageCount = count / Board.LIST_AMOUNT;
		} else {
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
}
