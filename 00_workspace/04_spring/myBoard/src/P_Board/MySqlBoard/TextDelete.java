package P_Board.MySqlBoard;

import java.sql.SQLException;
import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * TextDelete 클래스 - 글 삭제 기능을 담당하는 클래스입니다.
 */
public class TextDelete extends Db {

	/**
	 * 글 삭제 실행 메서드
	 */
	public static void TextDeleteRun() {
		int memberid = 0;

		loop: do {
			Cw.wn("===================================");
			Cw.wn("현재 본인이 게시판에 등록한 글 리스트입니다.");
			Cw.wn("삭제를 원하시는 게시글의 번호를 입력해주세요.");
			Cw.wn("===================================");

			try {
				// 현재 로그인한 회원의 고유번호 조회
				result = st.executeQuery("SELECT b_user FROM idpw WHERE b_id = '" + Login.myId + "'");
				result.next();
				memberid = result.getInt("b_user");

				// 현재 로그인한 회원이 작성한 글 리스트 조회
				result = st.executeQuery("SELECT * FROM board WHERE b_user = '" + memberid + "'");

				if (result.next()) {
					do {
						String number = result.getString("textnumber");
						String title = result.getString("b_title");
						String userid = result.getString("b_user");
						String datetime = result.getString("b_datetime");
						Cw.wn("번호 || 제목 || 작성 시간 || 유저 고유번호");
						Cw.wn(number + " || " + title + " || " + datetime + " || " + userid);
					} while (result.next());

					int checkNum;

					do {
						// 현재 로그인한 회원이 작성한 글 중에서 삭제할 글 번호 입력
						result = st.executeQuery("SELECT textnumber FROM board WHERE b_user = '" + memberid + "'");
						result.next();
						MainFunction.cmd = MainFunction.sc.next();
						String readNum = MainFunction.cmd;
						int readnumber = Integer.parseInt(readNum);

						// 입력한 번호에 해당하는 글 조회
						result = st.executeQuery("SELECT * FROM board WHERE textnumber = " + readnumber);
						result.next();
						checkNum = result.getInt("textnumber");

						if (readnumber == checkNum) {
							// 입력한 번호에 해당하는 글 삭제
							Db.dbHub("Other", "DELETE FROM board WHERE textnumber = " + readnumber);
							Cw.wn("[" + Login.myId + "]님께서 작성하신 " + readnumber + "번 게시글이 성공적으로 삭제되었습니다.");
							Cw.wn("-----------------------------------------------");

							// 삭제 후 사용자에게 다시 삭제 여부 확인
							loop1: do {
								Cw.wn("[r]또 삭제하기/[x]이전 메뉴");
								MainFunction.cmd = MainFunction.sc.next();

								switch (MainFunction.cmd) {
								case "r":
									continue loop;
								case "x":
									MenuDisp.MenuRun();
								default:
									Cw.wn("잘못 입력하셨습니다. 다시 입력해주세요.");
									continue loop1;
								}
							} while (true);
						} else {
							Cw.wn("입력하신 게시글 번호는 없는 번호이거나 [" + Login.myId + "]님께서 작성하신 게시글이 아닙니다.");
							continue loop;
						}
					} while (true);
				} else {
					// 현재 로그인한 회원이 작성한 글이 없는 경우
					Cw.wn("===================================");
					Cw.wn("[" + Login.myId + "]님께서 작성하신 게시글이 없습니다.");
					Cw.wn("메인 메뉴로 돌아갑니다.");
					Cw.wn("===================================");
					MenuDisp.MenuRun();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (true);
	}
}