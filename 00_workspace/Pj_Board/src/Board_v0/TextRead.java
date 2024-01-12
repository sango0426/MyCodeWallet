package Board_v0;

import java.sql.SQLException;

public class TextRead extends Db{
	public static void textReadRun() {
		loop: while(true) {
			
			// 작성된 글이 없는 경우
			if (MainFunction.texttitle.size() == 0) {
				Cw.wn("작성된 글이 없습니다. 이전 메뉴로 돌아갑니다.");
				Cw.wn("====================================");
				MenuDisp.MenuRun();
			} else {
				// 작성된 글이 있는 경우
				Cw.wn("===================================");
				Cw.wn("보고싶은 게시글의 번호를 입력해주세요");
				Cw.wn("[x]메인 메뉴");
				Cw.wn("===================================");
				try {
					result = st.executeQuery("select * from board");
					while(result.next()) {
						String number = result.getString("textnumber");
						String title = result.getString("b_title");
						String datetime = result.getString("b_datetime");
						Cw.wn(number + " || " + title + " || " + datetime);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				String readNum = MainFunction.sc.next();
				switch(readNum) {
				default:
					try {
						// 기존의 result를 닫고 새로운 Statement를 생성
                        result.close(); // 기존의 result를 닫음
						result = st.executeQuery("select * from board where textnumber = " + readNum);
						while(result.next()) {
							String number = result.getString("textnumber");
							String title = result.getString("b_title");
							String datetime = result.getString("b_datetime");
							String text = result.getString("b_text");
							Cw.wn("===================================");
							Cw.wn("번호 : " + number);
							Cw.wn("작성시간 : " + datetime);
							Cw.wn("제목 : " + title);
							Cw.wn("내용");
							Cw.wn("-----------------------------------");
							Cw.wn(text);
						}
					} catch(SQLException e) {
						e.printStackTrace();
					}
				case "x":
					MenuDisp.MenuRun();
				}
			}
		}
	}
}
