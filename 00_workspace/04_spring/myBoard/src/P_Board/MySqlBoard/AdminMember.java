package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.MySqlBoard.Display.AdminDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * AdminMember 클래스 - 관리자 전용 회원 관리 기능을 제공하는 클래스입니다.
 */
public class AdminMember extends Db {

	/**
	 * 관리자 전용 회원 관리 실행 메서드
	 */
	public static void AdminMemberRun() {
		member: while (true) {
			if (MainFunction.id.size() == 0) {
				// 등록된 회원이 없는 경우 메뉴로 돌아감
				Cw.wn("====================================");
				Cw.wn("현재 등록된 회원이 없습니다. 메뉴로 돌아갑니다.");
				Cw.wn("====================================");
				AdminDisp.adminRun();
			} else {
				// 등록된 회원이 있는 경우 회원 리스트 출력
				Cw.wn("=================================");
				Cw.wn("현재 등록된 회원 리스트입니다.");
				Cw.wn("=================================");
				try {
					result = st.executeQuery("SELECT * FROM idpw");
					while (result.next()) {
						String userid = result.getString("b_id");
						String uniqueNum = result.getString("b_user");
						Cw.wn("아이디 : " + userid + " || 고유번호 : " + uniqueNum);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// 회원 검색, 삭제, 이전 메뉴로 이동하는 메뉴 출력
				Cw.wn("=================================");
				Cw.wn("[s]회원 검색/[d]회원 삭제/[x]이전 메뉴");
				Cw.wn("=================================");
				MainFunction.cmd = MainFunction.sc.next();

				switch (MainFunction.cmd) {
				case "s":
					// 회원 검색 메뉴
					Cw.wn("=================================");
					Cw.wn("검색하고 싶은 회원의 아이디를 입력하세요");
					Cw.wn("=================================");
					MainFunction.cmd = MainFunction.sc.next();
					String searchId = MainFunction.cmd;
					try {
						result = st.executeQuery("SELECT * FROM idpw WHERE b_id = '" + searchId + "'");
						while (result.next()) {
							String resultId = result.getString("b_id");
							String uniqueNum = result.getString("b_user");
							Cw.wn("=================================");
							Cw.wn("검색된 회원 아이디 : " + resultId + " || 고유번호 : " + uniqueNum);
							Cw.wn("=================================");
						}
						continue member;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				case "d":
					// 회원 삭제 메뉴
					int searchNum = 0;
					Cw.wn("=================================");
					Cw.wn("삭제하고 싶은 회원의 고유번호를 입력하세요");
					Cw.wn("=================================");
					MainFunction.cmd = MainFunction.sc.next();
					String readNum = MainFunction.cmd;
					searchNum = Integer.parseInt(readNum);
					try {
						result = st.executeQuery("SELECT b_id FROM idpw WHERE b_user = " + searchNum);
						result.next();
						String resultId = result.getString("b_id");
						Cw.wn("=================================");
						Cw.wn("삭제할 회원 아이디 : " + resultId);
						Cw.wn("=================================");
						Cw.wn("[y]삭제하기/[n]삭제취소");
						Cw.wn("=================================");
						MainFunction.cmd = MainFunction.sc.next();
						switch (MainFunction.cmd) {
						case "y":
							// 삭제할 회원을 확인하고 삭제
							int idNum = 0;
							for (int i = 0; i < MainFunction.id.size(); i++) {
								if (resultId.equals(MainFunction.id.get(i).getId())) {
									idNum = i;
								}
							}
							Db.dbHub("Other", "DELETE FROM idpw WHERE b_user = " + searchNum);
							MainFunction.id.remove(idNum); // remove 메서드를 이용하여 특정 id 삭제
							MainFunction.pw.remove(idNum); // remove 메서드를 이용하여 특정 pw 삭제
							Cw.wn("=================================");
							Cw.wn("삭제가 완료되었습니다. 회원 리스트로 돌아갑니다.");
							Cw.wn("=================================");
							continue member;
						case "n":
							Cw.wn("=================================");
							Cw.wn("삭제가 취소되었습니다. 회원 리스트로 돌아갑니다.");
							Cw.wn("=================================");
							continue member;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				case "x":
					// 이전 메뉴로 이동
					AdminDisp.adminRun();
				}
			}
		}
	}
}