package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * TextFix 클래스 - 글 수정 기능을 담당하는 클래스입니다.
 */
public class TextFix extends Db {

	/**
	 * 글 수정 메서드
	 */
	public static void TextFixRun() {
		textFix: while (true) {
			// 작성된 글이 있는지 확인
			if (!MainFunction.texttitle.isEmpty()) {
				Fixstart: while (true) {
					// 게시글 목록 출력
					Cw.wn("=============================================================");
					Cw.wn("회원님이 작성하신 글입니다.");
					Cw.wn("어떤 글을 수정하시겠습니까? 수정을 원하시는 게시글의 번호를 입력해주세요.");
					Cw.wn("=============================================================");

					try {
						st = con.createStatement();
						result = st.executeQuery("select * from board");
						while (result.next()) {
							String number = result.getString("textnumber");
							String title = result.getString("b_title");
							String datetime = result.getString("b_datetime");
							Cw.wn(number + " || " + title + " || " + datetime);
							Cw.wn("=============================================================");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// 사용자로부터 번호 입력 받기
					String readNum = MainFunction.sc.next();

					// 입력된 값이 숫자인지 확인
					if (readNum.matches("\\d+")) {
						// 수정할 제목 입력
						int selectedNum = Integer.parseInt(readNum);
						Cw.wn("새로운 제목을 입력하세요.");
						Cw.wn("=================================");
						MainFunction.cmd = MainFunction.sc.next();
						String newTitle = MainFunction.cmd;
						MainFunction.sc.nextLine(); // 토큰 소비

						// 수정할 내용 입력
						Cw.wn("=================================");
						Cw.wn("새로운 내용을 입력하세요.(빈줄로 종료)");
						Cw.wn("=================================");
						StringBuilder textBodyBuilder = new StringBuilder();
						while (true) {
							MainFunction.cmd = MainFunction.sc.nextLine();
							if (MainFunction.cmd.isEmpty()) {
								break;
							}
							textBodyBuilder.append(MainFunction.cmd).append("\n");
						}
						String newTextBody = textBodyBuilder.toString().trim();
						Cw.wn("=================================");
						Cw.wn("수정된 게시글 입니다");
						Cw.wn("제목 : " + newTitle);
						Cw.wn("내용");
						Cw.wn("---------------------------------");
						Cw.wn(newTextBody);
						Cw.wn("=================================");
						Cw.wn("[y]수정하기/[n]수정취소/[x]이전화면");
						Cw.wn("=================================");
						MainFunction.cmd = MainFunction.sc.next();

						switch (MainFunction.cmd) {
						case "y":
							// MainFunction 클래스의 리스트에도 업데이트
							MainFunction.textbody.get(selectedNum - 1).setBody(newTextBody);
							MainFunction.texttitle.get(selectedNum - 1).setTitle(newTitle);

							// 데이터베이스 업데이트
							Db.dbHub("Other", "update board set b_title = '" + newTitle + "', b_text = '" + newTextBody
									+ "' where textnumber = " + readNum);

							// 수정 완료 메시지 출력
							Cw.wn("게시글이 성공적으로 수정되었습니다.");
							Cw.wn("=================================");
							Cw.wn("메인 메뉴 화면으로 돌아갑니다.");
							// 글 수정 완료 후 메인메뉴로 돌아감
							MenuDisp.MenuRun();
						case "n":
							continue Fixstart;
						case "x":
							MenuDisp.MenuRun();
						}
					}
				}
			} else {
				// 작성된 글이 없을 때 메시지 출력
				Cw.wn("회원님께서 작성하신 게시글이 없습니다. 메인메뉴로 돌아갑니다.");
				MenuDisp.MenuRun();
			}
		}
	}
}