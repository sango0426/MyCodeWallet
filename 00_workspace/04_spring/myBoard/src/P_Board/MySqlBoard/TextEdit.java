package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * TextEdit 클래스 - 답글 수정 및 삭제 기능을 담당하는 클래스입니다.
 */
public class TextEdit extends Db {

	/**
	 * 답글 수정 및 삭제 실행 메서드
	 */
	public static void textEditRun() {
		int memberid = 0;

		loop: do {
			Cw.wn("===================================");
			Cw.wn("현재 본인이 게시판에 등록한 답글 리스트입니다.");
			Cw.wn("삭제를 원하시는 답글 번호를 입력해주세요.");
			Cw.wn("[x.이전 화면]");
			Cw.wn("===================================");

			try {
				// 현재 로그인한 회원의 고유번호 조회
				result = st.executeQuery("SELECT b_user FROM idpw WHERE b_id = '" + Login.myId + "'");
				result.next();
				memberid = result.getInt("b_user");

				// 현재 로그인한 회원이 작성한 답글 리스트 조회
				result = st.executeQuery("SELECT * FROM reply WHERE r_user = '" + memberid + "'");

				if (result.next()) {
					do {
						String number = result.getString("r_number");
						String text = result.getString("r_replytext");
						String userid = result.getString("r_user");
						String datetime = result.getString("r_datetime");
						Cw.wn("번호 || 내용 || 작성 시간 || 유저 고유번호");
						Cw.wn(number + " || " + text + " || " + datetime + " || " + userid);
					} while (result.next());

					// 사용자로부터 번호 입력 받기
					int checkNum;

					do {
						MainFunction.cmd = MainFunction.sc.next();
						String readNum = MainFunction.cmd;

						if (readNum.equals("x")) {
							TextRead.textReadRun();
						} else {
							int readnumber = Integer.parseInt(readNum);
							result = st.executeQuery("SELECT * FROM reply WHERE r_number = " + readnumber);
							result.next();
							checkNum = result.getInt("r_number");

							if (readnumber == checkNum) {
								// 입력한 번호에 해당하는 답글 삭제
								Db.dbHub("Other", "DELETE FROM reply WHERE r_number = " + readnumber);
								Cw.wn("[" + Login.myId + "]님께서 작성하신 " + readnumber + "번 답글이 성공적으로 삭제되었습니다.");
								Cw.wn("-----------------------------------------------");

								// 삭제 후 사용자에게 다시 삭제 여부 확인
								loop1: do {
									Cw.wn("[r]또 삭제하기/[x]이전 메뉴");
									MainFunction.cmd = MainFunction.sc.next();

									switch (MainFunction.cmd) {
									case "r":
										continue loop;
									case "x":
										TextRead.textReadRun();
									default:
										Cw.wn("잘못 입력하셨습니다. 다시 입력해주세요.");
										continue loop1;
									}
								} while (true);
							} else {
								Cw.wn("입력하신 답글 번호는 없는 번호이거나 [" + Login.myId + "]님께서 작성하신 답글이 아닙니다.");
								continue loop;
							}
						}
					} while (true);
				} else {
					// 현재 로그인한 회원이 작성한 답글이 없는 경우
					Cw.wn("===================================");
					Cw.wn("[" + Login.myId + "]님께서 작성하신 답글이 없습니다.");
					Cw.wn("글읽기 메뉴로 돌아갑니다.");
					Cw.wn("===================================");
					TextRead.textReadRun();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (true);
	}
}