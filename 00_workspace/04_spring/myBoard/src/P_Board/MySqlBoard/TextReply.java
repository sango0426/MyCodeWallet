package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.Data.ReplyData;
import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * TextReply 클래스 - 답글 작성 기능을 담당하는 클래스입니다.
 */
public class TextReply extends Db {
	/**
	 * 답글 작성 메서드
	 */
	public static void textReplyRun() {
		int memberid = 0;
		int indexcode = MainFunction.textreply.size() + 1;

		MainFunction.sc.nextLine(); // 엔터 소진
		Cw.wn("===============================");
		Cw.wn("답글 내용을 입력해주세요");
		Cw.wn("(최대 50자, 엔터 2번 누르면 입력완료)");
		Cw.wn("===============================");
		StringBuilder textBodyBuilder = new StringBuilder();
		while (true) {
			MainFunction.cmd = MainFunction.sc.nextLine();
			if (MainFunction.cmd.isEmpty()) {
				break;
			}
			textBodyBuilder.append(MainFunction.cmd).append("\n");
		}
		String inputReply = textBodyBuilder.toString().trim();
		Cw.wn("================================");
		Cw.wn("아래와 같이 작성을 완료하겠습니까?");
		Cw.wn("답글내용");
		Cw.wn("--------------------------------");
		Cw.wn(inputReply); // 글내용 출력
		Cw.wn("================================");
		Cw.wn("[y.네][n.아니요][x.이전메뉴로 돌아가기]");
		Cw.wn("================================");

		// 사용자 선택에 따른 분기
		MainFunction.cmd = MainFunction.sc.next();
		switch (MainFunction.cmd) {
		case "y":
			try {
				result = st.executeQuery("SELECT b_user FROM idpw WHERE b_id = '" + Login.myId + "'");
				result.next();
				memberid = result.getInt("b_user");
				Cw.wn(Login.myId + "의 고유 번호 : " + memberid + "");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			MainFunction.textreply.add(new ReplyData(inputReply));
			Db.dbHub("Other", "Insert into reply(r_number, r_user, r_datetime, r_replytext, r_userid) value ("
					+ indexcode + ", '" + memberid + "', now(), '" + inputReply + "', '" + Login.myId + "')");
			Cw.wn("댓글이 성공적으로 저장되었습니다.");
			Cw.wn("이전 메뉴로 돌아갑니다.");
			TextRead.textReadRun();
		case "n":
			Cw.wn("글 작성을 취소합니다.");
			Cw.wn("이전 메뉴로 돌아갑니다.");
			TextRead.textReadRun();
		case "x":
			TextRead.textReadRun();
		}
	}
}