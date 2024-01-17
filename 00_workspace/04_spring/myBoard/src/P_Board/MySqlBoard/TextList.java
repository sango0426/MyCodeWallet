package P_Board.MySqlBoard;

import java.sql.SQLException;

import P_Board.MySqlBoard.Display.AdminDisp;
import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;
import P_Board.Util.Db;

/**
 * TextList 클래스 - 글 목록 조회 기능을 담당하는 클래스입니다.
 */
public class TextList extends Db {
	static public final int PER_PAGE = 3;

	/**
	 * 글 목록 조회 메서드
	 */
	public static void TextListRun() {
		int startIndex = 0; // 현재 페이지의 첫 글 인덱스
		int currentPage = 1; // 현재 페이지

		/// 전체 페이지 구하기 ///
		int totalPage = 0;
		if (Db.getPostCount() % PER_PAGE > 0) {
			totalPage = Db.getPostCount() / PER_PAGE + 1;
		} else {
			totalPage = Db.getPostCount() / PER_PAGE;
		}
		menu: while (true) {
			Cw.wn("===============================");
			Cw.wn("공지사항 리스트");
			Cw.wn("-------------------------------");
			try {
				result = st.executeQuery("SELECT * FROM adminboard");
				while (result.next()) {
					int number = result.getInt("a_number");
					String title = result.getString("a_title");
					String datetime = result.getString("a_datetime");
					int hit = result.getInt("a_hit");
					Cw.wn(number + " || " + title + " || " + datetime + " || " + hit);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Cw.wn("===============================");
			Cw.wn("솔데스크's 글 리스트");
			Cw.wn("-------------------------------");
			Cw.wn("총 페이지 : " + totalPage);
			Cw.wn("===============================");
			Cw.wn("[i]페이지 입력/[s]검색하기/[x]이전 화면");
			MainFunction.cmd = MainFunction.sc.next();
			loop: while (true) {
				if (MainFunction.cmd.equals("x")) {
					if(Login.myId.equals("게시판 관리자")) {
						AdminDisp.adminRun();
					} else {
						MenuDisp.MenuRun();
					}
				} else if (MainFunction.cmd.equals("i")) {
					loop1: while (true) {
						try {
							Cw.wn("===============================");
							Cw.wn("열람하실 페이지를 입력해주세요");
							Cw.wn("===============================");
							MainFunction.cmd = MainFunction.sc.next();
							currentPage = Integer.parseInt(MainFunction.cmd);
							if (currentPage > totalPage || currentPage < 1) {
								Cw.wn("페이지 범위에 맞는 값을 넣어주세요");
								continue loop;
							} else {
								startIndex = (currentPage - 1) * PER_PAGE;
								try {
									result = st
											.executeQuery("select * from board limit " + startIndex + ", " + PER_PAGE);
									Cw.wn("전송한sql문:" + result);
									while (result.next()) {
										String no = result.getString("textnumber");
										String title = result.getString("b_title");
										String userid = result.getString("b_user");
										String datetime = result.getString("b_datetime");
										int hit = result.getInt("b_hit");
										Cw.wn(no + " || " + title + " || " + datetime + " || " + userid + " || " + hit);
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						} catch (NumberFormatException e) {
							Cw.wn("잘못된 입력입니다. 숫자를 입력해주세요.");
							continue loop1;
						}
						continue menu;
					}
				} else if (MainFunction.cmd.equals("s")) {
					search: while (true) {
						Cw.wn("===============================");
						Cw.wn("검색하실 종류를 선택해주세요");
						Cw.wn("===============================");
						Cw.wn("[1]제목/[2]내용/[x]이전화면");
						Cw.wn("===============================");
						String searchKind = MainFunction.sc.next();
						switch (searchKind) {
						case "1":
							try {
								Cw.wn("===============================");
								Cw.wn("검색하실 제목을 입력해주세요");
								Cw.wn("===============================");
								String search = MainFunction.sc.next();
								Cw.wn("===============================");
								result = st.executeQuery("SELECT * FROM board WHERE b_title LIKE '%" + search + "%'");
								boolean found = false;
								while (result.next()) {
									String searchText = result.getString("b_title");
									Cw.wn("===============================");
									Cw.wn("검색하신 내용이 포함된 게시글입니다.");
									Cw.wn("===============================");

									String no = result.getString("textnumber");
									String title = result.getString("b_title");
									String textbody = result.getString("b_text");
									String userid = result.getString("b_user");
									String datetime = result.getString("b_datetime");
									int hit = result.getInt("b_hit");
									Cw.wn(no + " || " + title + " || " + datetime + " || " + userid + " || " + hit);
									Cw.wn("----------------------------------------");
									Cw.wn(textbody);
									found = true;
								}
								if (!found) {
									Cw.wn("===============================");
									Cw.wn("검색하신 제목이 존재하지 않습니다.");
									Cw.wn("===============================");
									continue search;
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							Cw.wn("===============================");
							Cw.wn("검색메뉴로 이동합니다.");
							Cw.wn("===============================");
							continue search;
						case "2":
							try {
								Cw.wn("===============================");
								Cw.wn("검색하실 내용을 입력해주세요");
								Cw.wn("===============================");
								String search = MainFunction.sc.next();
								Cw.wn("===============================");
								result = st.executeQuery("SELECT * FROM board WHERE b_text LIKE '%" + search + "%'");
								boolean found = false;
								while (result.next()) {
									String searchText = result.getString("b_text");
									Cw.wn("===============================");
									Cw.wn("검색하신 내용이 포함된 게시글입니다.");
									Cw.wn("===============================");

									String no = result.getString("textnumber");
									String title = result.getString("b_title");
									String textbody = result.getString("b_text");
									String userid = result.getString("b_user");
									String datetime = result.getString("b_datetime");
									int hit = result.getInt("b_hit");
									Cw.wn(no + " || " + title + " || " + datetime + " || " + userid + " || " + hit);
									Cw.wn("----------------------------------------");
									Cw.wn(textbody);
									found = true;
								}
								if (!found) {
									Cw.wn("===============================");
									Cw.wn("검색하신 내용이 존재하지 않습니다.");
									Cw.wn("===============================");
									continue search;
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							Cw.wn("===============================");
							Cw.wn("검색메뉴로 이동합니다.");
							Cw.wn("===============================");
							continue search;
						case "x":
							continue menu;
						}
					}
				} else {
					Cw.wn("없는 메뉴입니다. 다시 입력해주세요.");
					continue menu;
				}
			}
		}
	}
}