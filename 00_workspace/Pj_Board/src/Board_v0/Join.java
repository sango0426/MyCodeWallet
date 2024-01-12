package Board_v0;

import java.sql.ResultSet;
import java.sql.SQLException;

// 회원가입 기능을 담당하는 클래스
public class Join extends Db {
	// 회원가입 실행 메서드
	public static void JoinRun() {
		// 데이터베이스 초기화 메서드 호출 (주석 처리된 부분)
//        Db.dbInit();

		boolean idFound = false;
		int index = -1;
		String userid = "";
		String userpw = "";
		int memberid = 0;

		JoinId: while (true) {
			// 각 회원가입 시마다 idFound를 초기화
			Cw.wn("-------------------------");
			Cw.wn("회원가입 페이지");
			Cw.wn("-------------------------");
			Cw.wn("등록하실 아이디를 입력하세요.");
			Cw.wn("-------------------------");
			userid = MainFunction.sc.next();
			
			// 아이디 중복체크(equals로 배열에 입력된 아이디가 이미 있는지 확인)
			for (int i = 0; i < MainFunction.id.size(); i++) {
				if (userid.equals(MainFunction.id.get(i).getId())) {
					// 이미 리스트에 존재하는 경우
					idFound = true;
					index = i;
					Cw.wn("------------------------------");
					Cw.wn("중복된 아이디입니다. 다시 입력해주세요");
					Cw.wn("------------------------------");
					continue JoinId;
				}
			}

			if (!idFound) {
				// 리스트에 존재하지 않는 경우

				checkPw: while (true) {
					Cw.wn("-------------------------");
					Cw.wn("등록하실 비밀번호를 입력하세요.");
					Cw.wn("주의. 12자리 이하로 입력해주세요!!");
					Cw.wn("-------------------------");
					userpw = MainFunction.sc.next();

					// 비밀번호 12자리 검사
					if (userpw.length() <= 12) {
						Cw.wn("-------------------------");
						Cw.wn("등록하실 아이디와 비밀번호입니다");
						Cw.wn("맞는지 다시 한번 확인해주세요");
						Cw.wn("아이디 : " + userid);
						Cw.wn("비밀번호 : " + userpw);
						Cw.wn("-------------------------");
						Cw.wn("[y]등록 / [n]다시 입력");
						MainFunction.cmd = MainFunction.sc.next();

						switch (MainFunction.cmd) {
						case "y":
							// 데이터베이스에 추가
							// id와 pw 정보를 배열에 저장
							MainFunction.id.add(new IdData(userid));
							MainFunction.pw.add(new PwData(userpw));

							// 데이터베이스에도 등록
							Db.dbHub("Other",
									"Insert into idpw (b_id, b_pw) values ('" + userid + "'," + "'" + userpw + "')");

							Cw.wn("-------------------------");
							Cw.wn("회원가입이 완료되었습니다.");
							Cw.wn("메뉴로 돌아갑니다.");
							Cw.wn("-------------------------");
							MainDisp.run();

						case "n":
							continue JoinId;
						}
					} else {
						Cw.wn("-------------------------");
						Cw.wn("비밀번호 길이가 12자리를 넘습니다");
						Cw.wn("다시 입력해주세요.");
						Cw.wn("-------------------------");
						userpw = "";
						continue checkPw;
					}
				}
			}
		}
	}
}
