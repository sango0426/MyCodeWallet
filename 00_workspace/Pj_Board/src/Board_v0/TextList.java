package Board_v0;

import java.sql.SQLException;

public class TextList extends Db {
	
	// 글 목록 조회 메서드
	public static void TextListRun() {
		Cw.wn("===============================");
		Cw.wn("솔데스크's 글 리스트");
		Cw.wn("===============================");

		// 작성된 글이 없는 경우
		if (MainFunction.texttitle.size() == 0) {
			Cw.wn("작성된 글이 없습니다. 이전 메뉴로 돌아갑니다.");
			Cw.wn("====================================");
			MenuDisp.MenuRun();
		} else {
			// 작성된 글이 있는 경우
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
			
			// 이전 메뉴로 돌아가기
			Cw.wn("====================================");
			Cw.wn("[x.이전 메뉴]");
			Cw.wn("====================================");
			MainFunction.cmd = MainFunction.sc.next();
			switch (MainFunction.cmd) {
			case "x":
				MenuDisp.MenuRun();
			}
		}
	}
}
