package Board_v0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;
	public static ResultSet result2 = null;

	
	public static void dbHub(String crud, String query) {
		if(crud.equals("Select")) {
			dbExecuteQuery(query);
		} else if(crud.equals("Other")) {
			dbExecuteUpdate(query);
		}
	}

	public static void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement(); // Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열
										// 수있다.
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}

	}

	private static void dbExecuteQuery(String query) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();
			result = st.executeQuery(query);
			while (result.next()) { // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				String name = result.getString("b_title"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println(name);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}

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
}
