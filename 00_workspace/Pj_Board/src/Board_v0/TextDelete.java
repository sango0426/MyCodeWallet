package Board_v0;

import java.sql.SQLException;

public class TextDelete extends Db {
	public static void TextDeleteRun() {
//		loop: 
		while (true) {
			Cw.wn("===================================");
			Cw.wn("현재 본인이 게시판에 등록한 글리스트입니다.");
			Cw.wn("삭제를 원하시는 게시글의 번호를 입력해주세요.");
			Cw.wn("===================================");
			try {
				result = st.executeQuery("SELECT b_user FROM idpw WHERE b_id = '" + Login.myId + "'");
				result.next();
				int memberid = result.getInt("b_user"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				Cw.wn(Login.myId + "의 고유 번호 : " + memberid + "");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// 사용자로부터 번호 입력 받기
			MainFunction.cmd = MainFunction.sc.next();
			String readNum = MainFunction.cmd;
			MainFunction.sc.nextLine(); // 엔터를 소비하기 위해 추가
		}
	}
}
