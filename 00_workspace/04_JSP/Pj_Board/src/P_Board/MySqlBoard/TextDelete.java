package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

public class TextDelete extends Db {
	public static void TextDeleteRun() {
		int memberid = 0;
		try {
			loop: while (true) {
				Cw.wn("===================================");
				Cw.wn("현재 본인이 게시판에 등록한 글리스트입니다.");
				Cw.wn("삭제를 원하시는 게시글의 번호를 입력해주세요.");
				Cw.wn("===================================");
				try {
					result = st.executeQuery("SELECT b_user FROM idpw WHERE b_id = '" + Login.myId + "'");
					result.next();
					memberid = result.getInt("b_user");
					result2 = st.executeQuery("SELECT * FROM board WHERE b_user = '" + memberid + "'");
					while (result2.next()) {
						String number = result2.getString("textnumber");
						String title = result2.getString("b_title");
						String userid = result2.getString("b_user");
						String datetime = result2.getString("b_datetime");
						Cw.wn("번호 || 제목 || 작성 시간 || 유저 고유번호");
						Cw.wn(number + " || " + title + " || " + datetime + " || " + userid);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// 사용자로부터 번호 입력 받기
				MainFunction.cmd = MainFunction.sc.next();
				String readNum = MainFunction.cmd;
				result = st.executeQuery("SELECT b_user FROM idpw WHERE b_id = '" + Login.myId + "'");
				result.next();
				memberid = result.getInt("b_user");
				result2 = st.executeQuery("SELECT * FROM board WHERE b_user = '" + memberid + "'");
				result2.next();
				String checkNum = result2.getString("textnumber");
				if (readNum.equals(checkNum)) {
					int readnumber = Integer.parseInt(readNum);
					Db.dbHub("Other", "DELETE FROM board WHERE textnumber = " + readnumber);
					Cw.wn(Login.myId + "께서 작성하신 게시글이 성공적으로 삭제되었습니다.");
					Cw.wn("------------------------------------------");
					loop1: while (true) {
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
					}
				} else {
					Cw.wn("선택하신 게시글 번호는 없는 번호이거나 [" + Login.myId + "]께서 작성하신 게시글이 아닙니다.");
					continue loop;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
