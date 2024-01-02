package Board_v0;

// 메뉴를 표시하고 사용자의 선택에 따라 각각의 기능을 호출하는 클래스
public class MenuDisp {
	// 메뉴 실행 메서드
	public static void MenuRun() {
		menu1: while (true) {
			// 메뉴 출력
			Cw.wn("===========================================");
			Cw.wn("메뉴를 선택해주세요!");
			Cw.wn("[1]글리스트/[2]글쓰기");
			Cw.wn("[3]글수정/[4]글삭제/[x]로그아웃");
			MainFunction.cmd = MainFunction.sc.next();

			// 사용자 메뉴 선택에 따른 분기
			switch (MainFunction.cmd) {
			case "1":
				// 글 리스트 기능 호출
				TextList.TextListRun();
				continue menu1;
			case "2":
				// 글 쓰기 기능 호출
				TextWrite.TextWriteRun();
				continue menu1;
			case "3":
				// 글 수정 기능 호출
				TextFix.TextFixRun();
				continue menu1;
			case "4":
				// 글 삭제 기능 호출
				TextDelete.TextDeleteRun();
				continue menu1;
			case "x":
				// 로그아웃
				Cw.wn("---------------------");
				Cw.wn("로그아웃합니다.");
				break menu1;
			}
		}
	}
}
