package Board_v0;

// 회원가입 기능을 담당하는 클래스
public class Join {
	// 회원가입 실행 메서드
	public static int JoinRun() {
		Cw.wn("-------------------------");
		Cw.wn("회원가입 페이지");
		Cw.wn("-------------------------");
		Cw.wn("등록하실 아이디를 입력하세요.(숫자 4자리)");
		Cw.wn("-------------------------");

		// 아이디 입력 및 확인
		JoinId: while (true) {
			MainFunction.cmd = MainFunction.sc.next();
			if (MainFunction.cmd.length() == 4) {
				boolean idCheck = false;

				// 아이디 중복 확인
				for (int i = 0; i < MainFunction.id.size(); i++) {
					if (MainFunction.cmd.equals(MainFunction.id.get(i).getId())) {
						Cw.wn("사용중인 아이디입니다.");
						Cw.wn("다시 입력해주세요.");
						Cw.wn("-------------------------");
						idCheck = true;
						break;
					}
				}

				if (!idCheck) {
					// 아이디 중복이 아닐 경우 아이디를 저장하고 반복문 종료
					IdData idData = new IdData(MainFunction.cmd);
					MainFunction.id.add(idData);
					break JoinId;
				}
			} else {
				// 올바르지 않은 형식의 아이디 입력 시 안내 메시지
				Cw.wn("올바른 형식의 아이디가 아닙니다.");
				Cw.wn("다시 입력하세요.");
			}
		}

		// 패스워드 입력 및 확인
		Cw.wn("패스워드를 입력하세요.(숫자 4자리)");
		Cw.wn("-------------------------");
		JoinPw: while (true) {
			MainFunction.cmd = MainFunction.sc.next();
			if (MainFunction.cmd.length() == 4) {
				// 패스워드를 저장하고 회원가입 완료 안내 메시지 출력
				PwData pwData = new PwData(MainFunction.cmd);
				MainFunction.pw.add(pwData);
				Cw.wn("-------------------------");
				Cw.wn("회원가입 완료. 이전 화면으로 돌아갑니다.");
				Cw.wn("-------------------------");
				break JoinPw;
			} else {
				// 올바르지 않은 형식의 패스워드 입력 시 안내 메시지
				Cw.wn("올바른 형식의 패스워드가 아닙니다.");
				Cw.wn("다시 입력하세요.");
			}
		}

		// 회원가입 완료 시 0을 반환
		return 0;
	}
}
