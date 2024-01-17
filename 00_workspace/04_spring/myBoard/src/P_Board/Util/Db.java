package P_Board.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Db 클래스 - 데이터베이스 관련 기능을 제공하는 유틸리티 클래스입니다.
 */
public class Db {
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;
	public static ResultSet result2 = null;

	/**
	 * 데이터베이스 작업 허브 메서드
	 * 
	 * @param crud  작업 유형 ("Select" 또는 "Other")
	 * @param query 실행할 SQL 쿼리
	 */
	public static void dbHub(String crud, String query) {
		if (crud.equals("Select")) {
			dbExecuteQuery(query);
		} else if (crud.equals("Other")) {
			dbExecuteUpdate(query);
		}
	}

	/**
	 * 데이터베이스 초기화 메서드 - 데이터베이스 연결 및 Statement 객체 생성
	 */
	public static void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}

	/**
	 * SELECT 쿼리 실행 메서드
	 * 
	 * @param query 실행할 SELECT 쿼리
	 */
	private static void dbExecuteQuery(String query) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();
			result = st.executeQuery(query);
			while (result.next()) {
				String name = result.getString("b_title");
				System.out.println(name);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}

	/**
	 * UPDATE, INSERT, DELETE 등의 쿼리 실행 메서드
	 * 
	 * @param query 실행할 UPDATE, INSERT, DELETE 등의 쿼리
	 */
	public static void dbExecuteUpdate(String query) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();
			int resultCount = st.executeUpdate(query);
			System.out.println("처리된 행 수:" + resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시물 수 조회 메서드 (화면 출력)
	 */
	static public void dbPostCount() {
		try {
			Db.result = Db.st.executeQuery("select count(*) from board");
			Db.result.next();
			String count = Db.result.getString("count(*)");
			Cw.wn("글 수:" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 게시물 수 조회 메서드 (정수 반환)
	 * 
	 * @return 게시물 수
	 */
	static public int getPostCount() {
		String count = "";
		try {
			Db.result = Db.st.executeQuery("select count(*) from board");
			Db.result.next();
			count = Db.result.getString("count(*)");
			Cw.wn("글 수:" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		return intCount;
	}
}