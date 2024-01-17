package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.MySqlBoard.Display.AdminDisp;
import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * AdminTextDelete 클래스 - 관리자 전용 글 삭제 기능을 제공하는 클래스입니다.
 */
public class AdminTextDelete extends Db {

	/**
	 * 관리자 전용 글 삭제 실행 메서드
	 */
	public static void adminTextDeleteRun() {
		int memberid = 0;
		loop: do {
			Cw.wn("===================================");
			Cw.wn("현재 게시판에 등록한 글 리스트입니다.");
			Cw.wn("삭제를 원하시는 게시글의 번호를 입력해주세요.");
			Cw.wn("===================================");
			try {
				result = st.executeQuery("SELECT * FROM board");
				if (result.next()) {
					do {
						int number = result.getInt("textnumber");
						String title = result.getString("b_title");
						String userid = result.getString("b_user");
						String datetime = result.getString("b_datetime");
						Cw.wn("번호 || 제목 || 작성 시간 || 유저 고유번호");
						Cw.wn(number + " || " + title + " || " + datetime + " || " + userid);
					} while (result.next());

					int number = 0;
					do {
						MainFunction.cmd = MainFunction.sc.next();
						String readNum = MainFunction.cmd;
						int readnumber = Integer.parseInt(readNum);
						result = st.executeQuery("SELECT * FROM board WHERE textnumber = " + readnumber);
						while (result.next()) {
							number = result.getInt("textnumber");
							String title = result.getString("b_title");
							String userid = result.getString("b_user");
							String datetime = result.getString("b_datetime");
							String text = result.getString("b_text");
							Cw.wn("================================");
							Cw.wn("아래 게시글을 정말 지우시겠습니까?");
							Cw.wn("제목 : " + title); // 글제목 출력
							Cw.wn("내용"); // 글내용 출력
							Cw.wn("--------------------------------");
							Cw.wn(text); // 글내용 출력
							Cw.wn("================================");
							Cw.wn("[y.네][n.아니요][x.이전메뉴로 돌아가기]");
							Cw.wn("================================");
						}
						MainFunction.cmd = MainFunction.sc.next();
						switch (MainFunction.cmd) {
						case "y":
							if (readnumber == number) {
								Db.dbHub("Other", "DELETE FROM board WHERE textnumber = " + readnumber);
								Cw.wn(readnumber + "번 게시글이 성공적으로 삭제되었습니다.");
								Cw.wn("-----------------------------------------------");
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
								Cw.wn("입력하신 게시글 번호는 없는 번호입니다.");
								continue loop;
							}
						case "n":
							Cw.wn("삭제를 취소합니다.");
							Cw.wn("글리스트를 다시 출력합니다.");
							continue loop;
						case "x":
							AdminDisp.adminRun();
						}
					} while (true);
				} else {
					Cw.wn("===================================");
					Cw.wn("현재 게시판에 작성된 게시글이 없습니다.");
					Cw.wn("메인 메뉴로 돌아갑니다.");
					Cw.wn("===================================");
					AdminDisp.adminRun();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (true);
	}
}