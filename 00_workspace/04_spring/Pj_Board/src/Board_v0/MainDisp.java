package Board_v0;

public class MainDisp {

	// 게시판 메인 디스플레이 메서드
	void run() {
		boardstart: while (true) {
			// 회원아이디 입력
			Cw.wn("회원아이디(숫자 4자리)를 입력해주세요.");
			Cw.wn("-------------------------");
			MainFunction.cmd = MainFunction.sc.next();
			String board_id = MainFunction.cmd;

			// 회원아이디 검증
			if (board_id.length() == 4) {
				if ("0000".equals(board_id)) { // 관리자 계정인 경우
					menu1: while (true) {
						// 관리자 메뉴 출력
						Cw.wn("===========================================");
						Cw.wn("메뉴를 선택해주세요!");
						Cw.wn("[1]글리스트/[2]글쓰기");
						Cw.wn("[3]글수정/[4]글삭제/[x]프로그램 종료");
						MainFunction.cmd = MainFunction.sc.next();

						// 관리자 메뉴 선택에 따른 분기
						switch (MainFunction.cmd) {
						case "1":
							TextList.TextListRun();
							continue menu1;
						case "2":
							TextWrite.TextWriteRun();
							continue menu1;
						case "3":
							TextFix.TextFixRun();
							continue menu1;
						case "4":
							TextDelete.TextDeleteRun();
							continue menu1;
						case "x":
							Cw.wn("게시판 프로그램을 종료합니다.");
							break boardstart;
						}
					}
				} else { // 일반 사용자 계정인 경우
					menu2: while (true) {
						// 사용자 메뉴 출력
						Cw.wn("메뉴를 선택해주세요!");
						Cw.wn("[1]글리스트/[2]글쓰기/[3]글수정/[4]글삭제/[x]프로그램 종료");
						MainFunction.cmd = MainFunction.sc.next();

						// 사용자 메뉴 선택에 따른 분기
						switch (MainFunction.cmd) {
						case "1":
							TextList.TextListRun();
							continue menu2;
						case "2":
							TextWrite.TextWriteRun();
							continue menu2;
						case "3":
							TextFix.TextFixRun();
							continue menu2;
						case "4":
							TextDelete.TextDeleteRun();
							continue menu2;
						case "x":
							Cw.wn("게시판 프로그램을 종료합니다.");
							break boardstart;
						}
					}
				}
			} else {
				// 올바르지 않은 아이디 입력 시 다시 입력 안내
				Cw.wn("다시 회원아이디(숫자 4자리)를 입력하세요.");
				// MainFunction.id.clear();
			}
		}
	}
}
