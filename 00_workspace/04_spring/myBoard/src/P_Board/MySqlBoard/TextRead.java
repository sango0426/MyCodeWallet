package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * TextRead 클래스 - 게시글 조회 기능을 담당하는 클래스입니다.
 */
public class TextRead extends Db {
	/**
	 * 게시글 조회 메서드
	 */
	public static void textReadRun() {
		loop: while (true) {
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
					while (result.next()) {
						String number = result.getString("textnumber");
						String title = result.getString("b_title");
						String datetime = result.getString("b_datetime");
						Cw.wn(number + " || " + title + " || " + datetime);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				String readNum = MainFunction.sc.next();
				switch (readNum) {
				default:
					try {
						// 기존의 result를 닫고 새로운 Statement를 생성
						result.close(); // 기존의 result를 닫음
						result = st.executeQuery("select * from board where textnumber = " + readNum);
						if (result.next()) {
							button: do {
								String number = result.getString("textnumber");
								String title = result.getString("b_title");
								String datetime = result.getString("b_datetime");
								String text = result.getString("b_text");
								int hit = result.getInt("b_hit");
								hit = hit + 1;
								Cw.wn("===================================");
								Cw.wn("번호 : " + number);
								Cw.wn("조회수 : " + hit);
								Cw.wn("작성시간 : " + datetime);
								Cw.wn("제목 : " + title);
								Cw.wn("내용");
								Cw.wn("-----------------------------------");
								Cw.wn(text);
								Cw.wn("===================================");
								Cw.wn("답글 리스트");
								Cw.wn("-----------------------------------");
							} while (result.next());
							result = st.executeQuery("SELECT * FROM reply");
							while (result.next()) {
								String number = result.getString("r_number");
								String text = result.getString("r_replytext");
								String userid = result.getString("r_user");
								String datetime = result.getString("r_datetime");
								String user = result.getString("r_user");
								Cw.wn("답글번호 || 내용 || 작성 시간 || 작성자(ID)");
								Cw.wn(number + " || " + text + " || " + datetime + " || " + Login.myId);
							}
							Cw.wn("===================================");
							Cw.wn("[r]답글 달기/[e]답글 수정 및 삭제/[x]글리스트로 돌아가기");
							Cw.wn("===================================");
							MainFunction.cmd = MainFunction.sc.next();
							switch (MainFunction.cmd) {
							case "r":
								TextReply.textReplyRun();
							case "e":
								TextEdit.textEditRun();
							case "x":
								continue loop;
							default:
								Cw.wn("===================================");
								Cw.wn("잘못된 입력입니다. 다시 입력해주세요.");
								Cw.wn("===================================");

							}
						} else {
							Cw.wn("===================================");
							Cw.wn("입력하신 번호는 없는 게시글 번호입니다.");
							Cw.wn("===================================");
							continue loop;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				case "x":
					MenuDisp.MenuRun();
				}
			}
		}
	}
}