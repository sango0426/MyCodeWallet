package P_Board.MySqlBoard;

import P_Board.MySqlBoard.Display.MainDisp;
import P_Board.MySqlBoard.Display.MenuDisp;
import P_Board.Util.Cw;

// 로그인 기능을 담당하는 클래스
public class Login {
	// 로그인 기능 실행 메서드
	public static String myId;
	public static void LoginRun() {
		
		String userid = "";
		String userpw = "";
		// 아이디 입력 및 확인
		LoginId: while (true) {
			Cw.wn("-------------------------");
			Cw.wn("아이디 입력");
			Cw.wn("x.이전 화면");
			Cw.wn("-------------------------");

			// 사용자 입력 받기
			MainFunction.cmd = MainFunction.sc.next();
			userid = MainFunction.cmd;

			// 입력이 x라면 이전 화면으로 돌아가기
			switch (userid) {
			case "x":
				MainDisp.run();
			}

			// 회원가입된 아이디인가 검사하기
			boolean idFound = false;
			int index = -1;
			// 아이디 확인
			for (int i = 0; i < MainFunction.id.size(); i++) {
				if (userid.equals(MainFunction.id.get(i).getId())) {
					idFound = true;
					index = i;
				}
			}
			if (!idFound) {
				Cw.wn("-------------------------");
				Cw.wn("등록되지 않은 아이디입니다");
				Cw.wn("회원가입부터 진행해주세요");
				Cw.wn("[m]메인메뉴/[j]회원가입");
				Cw.wn("-------------------------");
				MainFunction.cmd = MainFunction.sc.next();
				switch (MainFunction.cmd) {
				case "m":
					MainDisp.run();
				case "j":
					Join.JoinRun();
				}
			} else {
				Cw.wn("-------------------------");
				Cw.wn("패스워드 입력");
				Cw.wn("-------------------------");

				// 패스워드 입력 및 확인
				LoginPw: while (true) {
					MainFunction.cmd = MainFunction.sc.next();
					userpw = MainFunction.cmd;
					if (userpw.length() <= 12) {
						// 패스워드 확인
						if (index >= 0 && index < MainFunction.pw.size()) {
							if (userpw.equals(MainFunction.pw.get(index).getPw())) {
								Cw.wn("로그인 성공!");
								break LoginId; // 로그인 성공 시 전체 반복문 종료
							} else {
								Cw.wn("패스워드 불일치. 다시 입력해주세요.");
								Cw.wn("-------------------------");
								break LoginPw; // 패스워드 불일치 시 현재 반복문 종료
							}
						}
					} else {
						Cw.wn("올바른 형식의 패스워드가 아닙니다.");
						Cw.wn("다시 입력하세요.");
						continue LoginPw;
					}
				}
			}
		}
		// 로그인 이후 메뉴 표시
		myId = userid;
		MenuDisp.MenuRun();
	}
}