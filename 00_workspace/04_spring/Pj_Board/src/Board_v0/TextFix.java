package Board_v0;

public class TextFix {

	// 글 수정 메서드
	public static int TextFixRun() {

		textFix: while (true) {
			// 작성된 글이 있는지 확인
			if (!MainFunction.texttitle.isEmpty()) {
				Cw.wn("=============================================================");
				Cw.wn("회원님이 작성하신 글입니다.");
				Cw.wn("어떤 글을 수정하시겠습니까? 수정을 원하시는 게시글의 번호를 입력해주세요.");
				Cw.wn("=============================================================");

				Fixstart: while (true) {
					// 게시글 목록 출력
					int size = Math.min(MainFunction.texttitle.size(), MainFunction.textbody.size());
					int listNum = 0;
					for (int i = 0; i < size; i++) {
						listNum++;
						Cw.wn("=================================");
						Cw.w("번호 : " + listNum);
						Cw.wn("/제목 : " + MainFunction.texttitle.get(i).getTitle());
						Cw.wn("---------------------------------");
						Cw.wn("내용 : " + MainFunction.textbody.get(i).getBody());
						Cw.wn("=================================");
					}

					// 사용자로부터 번호 입력 받기
					MainFunction.cmd = MainFunction.sc.next();

					// 입력된 값이 숫자인지 확인
					if (MainFunction.cmd.matches("\\d+")) {
						// 수정할 제목 입력
						int selectedNum = Integer.parseInt(MainFunction.cmd);
						Cw.wn("새로운 제목을 입력하세요.");
						Cw.wn("=================================");
						MainFunction.cmd = MainFunction.sc.next();
						MainFunction.sc.nextLine(); // 토큰 소비
						MainFunction.texttitle.get(selectedNum - 1).setTitle(MainFunction.cmd);

						// 수정할 내용 입력
						Cw.wn("=================================");
						Cw.wn("새로운 내용을 입력하세요. (빈줄로 종료)");
						Cw.wn("=================================");
						StringBuilder textBodyBuilder = new StringBuilder();
						while (true) {
							MainFunction.cmd = MainFunction.sc.nextLine();
							if (MainFunction.cmd.isEmpty()) {
								break;
							}
							textBodyBuilder.append(MainFunction.cmd).append("\n");
						}
						String newTextBody = textBodyBuilder.toString().trim();
						MainFunction.textbody.get(selectedNum - 1).setBody(newTextBody);

						// 수정 완료 메시지 출력
						Cw.wn("게시글이 성공적으로 수정되었습니다.");
						Cw.wn("=================================");
						Cw.wn("메인 메뉴 화면으로 돌아갑니다.");

						// 글 수정 완료 후 전체 코드 실행 중지
						break textFix;
					}
				}

			} else {
				// 작성된 글이 없을 때 메시지 출력
				Cw.wn("회원님께서 작성하신 게시글이 없습니다. 메인메뉴로 돌아갑니다.");
				break textFix;
			}
		}

		// 메서드 종료 시 반환 값
		return 0;
	}
}
