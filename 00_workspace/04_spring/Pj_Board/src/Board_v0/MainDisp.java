package Board_v0;

public class MainDisp {

	// 게시판 메인 디스플레이 메서드
	void run() {
		while (true) {
			// 메인 메뉴 표시
			Cw.wn("------------------------------");
			Cw.wn("솔데스크 게시판에 오신것을 환영합니다.");
			Cw.wn("[1.로그인/2.회원가입/x.프로그램 종료]");
			Cw.wn("------------------------------");

			// 사용자 입력 받기
			MainFunction.cmd = MainFunction.sc.next();

			// 사용자 입력에 따른 동작 수행
			switch (MainFunction.cmd) {
			case "1":
				// 로그인 메서드 호출
				Login.LoginRun();
				break;
			case "2":
				// 회원가입 메서드 호출
				Join.JoinRun();
				break;
			case "x":
				// 프로그램 종료
				Cw.wn("------------------------------");
				Cw.wn("프로그램이 종료됩니다.");
				Cw.wn("------------------------------");
				System.exit(0);
				break;
			default:
				// 잘못된 메뉴 선택 시 안내 메시지
				Cw.wn("올바른 메뉴를 선택하세요.");
			}
		}

	}
}
