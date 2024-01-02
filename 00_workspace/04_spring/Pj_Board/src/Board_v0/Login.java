package Board_v0;

// 로그인 기능을 담당하는 클래스
public class Login {
	// 로그인 기능 실행 메서드
	public static void LoginRun() {
		Cw.wn("-------------------------");
		Cw.wn("아이디 입력(숫자 4자리)");
		Cw.wn("x. 이전 화면");
		Cw.wn("-------------------------");

		// 사용자 입력 받기
		MainFunction.cmd = MainFunction.sc.next();

		// 이전 화면으로 돌아가기
		switch (MainFunction.cmd) {
		case "x":
			break;
		}

		// 아이디 입력 및 확인
		LoginId: while (true) {
			if (MainFunction.cmd.length() == 4) {
				boolean idFound = false;
				int index = -1;

				// 아이디 확인
				for (int i = 0; i < MainFunction.id.size(); i++) {
					if (MainFunction.cmd.equals(MainFunction.id.get(i).getId())) {
						idFound = true;
						index = i;
						break;
					}
				}

				if (idFound) {
					Cw.wn("-------------------------");
					Cw.wn("패스워드 입력(숫자 4자리)");
					Cw.wn("-------------------------");

					// 패스워드 입력 및 확인
					LoginPw: while (true) {
						MainFunction.cmd = MainFunction.sc.next();
						if (MainFunction.cmd.length() == 4) {
							// 패스워드 확인
							if (index >= 0 && index < MainFunction.pw.size()) {
								if (MainFunction.cmd.equals(MainFunction.pw.get(index).getPw())) {
									Cw.wn("로그인 성공!");
									break LoginId; // 로그인 성공 시 전체 반복문 종료
								} else {
									Cw.wn("패스워드 불일치. 다시 입력해주세요.");
									Cw.wn("-------------------------");
									break LoginPw; // 패스워드 불일치 시 현재 반복문 종료
								}
							} else {
								Cw.wn("오류: 패스워드를 찾을 수 없습니다.");
								Cw.wn("-------------------------");
								break LoginPw; // 패스워드를 찾을 수 없을 때 현재 반복문 종료
							}
						} else {
							Cw.wn("올바른 형식의 패스워드가 아닙니다.");
							Cw.wn("다시 입력하세요.");
						}
					}
				} else {
					Cw.wn("등록되지 않은 아이디입니다. 다시 입력해주세요.");
					Cw.wn("-------------------------");
				}
			} else {
				Cw.wn("올바른 형식의 아이디가 아닙니다.");
				Cw.wn("다시 입력하세요.");
			}
		}

		// 로그인 이후 메뉴 표시
		MenuDisp.MenuRun();
	}
}
