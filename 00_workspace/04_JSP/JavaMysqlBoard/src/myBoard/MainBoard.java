package myBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainBoard {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);
	
	void run() {
		Display.showTitle();
		dbInit();
		
		loop: while(true) {
			Display.showMainMenu();
			System.out.println("메뉴를 입력해주세요");
			System.out.println("=========================================");
			String cmd = sc.next();
			switch(cmd) {
			case "1":	// 글리스트
				System.out.println("==========================================");
				System.out.println("============== 게시판 글리스트 ==============");
				System.out.println("==========================================");
				System.out.println("번호 || 글제목 || ID || 작성시간");
				System.out.println("==========================================");
				try {
					result = st.executeQuery("select * from board_guest");
					while(result.next()) {
						String number = result.getString("board_number");
						String title = result.getString("board_title");
						String ID = result.getString("board_id");
						String datetime = result.getString("board_datetime");
						System.out.println(number + " || " + title + " || " + ID + " || " + datetime);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case "2":	// 글읽기
				System.out.println("==========================================");
				System.out.println("읽을 글 번호를 입력해주세요");
				System.out.println("==========================================");
				String readNum = sc.next();
				try {
					result = st.executeQuery("select * from board_guest where board_number = " + readNum);
					result.next();
					String number = result.getString("board_number");
					String title = result.getString("board_title");
					String ID = result.getString("board_id");
					String text = result.getString("board_text");
					System.out.println("==========================================");
					System.out.println("글번호 : " + number);
					System.out.println("글제목 : " + title);
					System.out.println("글내용 : " + text);
					System.out.println("작성자 : " + ID);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case "3":	// 글작성
				sc.nextLine(); // 위에 sc.next() 쓴거 때문에 추가함.
				System.out.println("==========================================");
				System.out.println("제목, 내용, 작성자의 ID를 입력해주세요");
				System.out.println("==========================================");
				System.out.println("제목을 입력해주세요");
				System.out.println("==========================================");
				String title = sc.nextLine();
				System.out.println("==========================================");
				System.out.println("내용을 입력해주세요");
				System.out.println("==========================================");
				String text = sc.nextLine();
				System.out.println("==========================================");
				System.out.println("작성자의 ID를 입력해주세요");
				System.out.println("==========================================");
				String ID = sc.next();
				try {
					st.executeUpdate("insert into board_guest(board_title, board_id, board_datetime, board_text, board_hit)" + " values('" 
				+ title + "','" + ID + "',now(),'" + text + "',0)");
					System.out.println("==========================================");
					System.out.println("글작성 완료");
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case "4":	// 글삭제
				System.out.println("==========================================");
				System.out.println("삭제를 원하시는 글의 번호를 입력하세요");
				System.out.println("==========================================");
				String delNum = sc.next();
				dbExecuteUpdate("delete from board_guest where board_number = " + delNum);
				break;
			case "5":	// 글수정
				System.out.println("==========================================");
				System.out.println("수정을 원하시는 글의 번호를 입력하세요");
				System.out.println("==========================================");
				String editNum = sc.next();
				System.out.println("==========================================");
				System.out.println("제목, 내용, 작성자의 ID를 입력해주세요");
				System.out.println("==========================================");
				System.out.println("제목을 입력해주세요");
				System.out.println("==========================================");
				// 주의. 이전에 sc.next() 등을 호출한적이 있으면 엔터 문자열이 남게 되는데 이거 때문에 다음에 나오는 nextLine()가
				// 입력을 이미 한것으로 인식하고 입력처리를 해버림(공백 입력이 된걸로 인식)
				// 그래서 sc.nextLine()을 한번 더 추가해주어 이 내용이 없는 엔터 문자열을 입력처리 하게끔하고
				sc.nextLine();
				String edTitle = sc.nextLine();	// << 여기에서 다시 정상적으로 쓰면됨.
				System.out.println("==========================================");
				System.out.println("내용을 입력해주세요");
				System.out.println("==========================================");
				String edText = sc.nextLine();
				System.out.println("==========================================");
				System.out.println("작성자의 ID를 입력해주세요");
				System.out.println("==========================================");
				String edID = sc.next();
				dbExecuteUpdate("update board_guest set board_title = '" + edTitle + "', board_id = '" + edID +
						"', board_datetime = now(), board_text = '" + edText + "' where board_number = " + editNum);
				break;
			case "0":	// 관리자
				
				break;
			case "x":	// 프로그램 종료
				
				break loop;
			}
		}
	}
	
	private void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_board", "root", "root");
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void dbExecuteUpdate(String Query) {
		try {
			int resultCount = st.executeUpdate(Query);
			System.out.println("처리된 행 수 : " + resultCount);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void dbPostCount() {
		try {
			result = st.executeQuery("select count(*) from board_guest");
			result.next();
			String count = result.getString("count(*)");
			System.out.println("==========================================");
			System.out.println("글 수 : " + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
