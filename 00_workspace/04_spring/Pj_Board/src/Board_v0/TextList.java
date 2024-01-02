package Board_v0;

public class TextList {

	// 글 목록 조회 메서드
	public static int TextListRun() {
		Cw.wn("===============================");
		Cw.wn("솔데스크's 글 리스트");
		Cw.wn("===============================");
		int listNum = 0;

		// 작성된 글이 없는 경우
		if (MainFunction.texttitle.size() == 0) {
			Cw.wn("작성된 글이 없습니다. 이전 메뉴로 돌아갑니다.");
			Cw.wn("====================================");
			return 0;
		} else {
			list: while (true) {
				int size = Math.min(MainFunction.texttitle.size(), MainFunction.textbody.size());

				// 글 목록 출력
				for (int i = 0; i < size; i++) {
					listNum++;
					Cw.wn("=================================");
					Cw.wn("번호 : " + listNum);
					Cw.wn("제목 : " + MainFunction.texttitle.get(i).getTitle());
					Cw.wn("=================================");
				}

				listChoice: while (true) {
					Cw.wn("====================================");
					Cw.wn("보고 싶은 게시글의 번호를 누르세요.");
					Cw.wn("x를 누르면 메인 메뉴으로 돌아갑니다.");
					Cw.wn("====================================");

					// 사용자로부터 번호나 x 입력 받기
					MainFunction.cmd = MainFunction.sc.next();

					// 입력값 검증
					if (MainFunction.cmd.matches("x")) {
						break list;
					}

					if (MainFunction.cmd.matches("\\d+")) {
						int selectedNum = Integer.parseInt(MainFunction.cmd);

						// 선택한 게시글 출력
						if (selectedNum > 0 && selectedNum <= size) {
							Cw.wn("게시글 번호: " + selectedNum);
							Cw.wn("제목: " + MainFunction.texttitle.get(selectedNum - 1).getTitle());
							Cw.wn("내용: " + MainFunction.textbody.get(selectedNum - 1).getBody());
						} else {
							Cw.wn("없는 게시글의 번호입니다. 다시 입력해주세요.");
							break listChoice;
						}
					} else {
						Cw.wn("올바르지 않은 입력입니다. 숫자를 입력하세요.");
						break listChoice;
					}
				}
				break list;
			}
		}

		// 이전 메뉴로 돌아가기
		Cw.wn("====================================");
		Cw.wn("[x.이전 메뉴]");
		Cw.wn("====================================");
		MainFunction.cmd = MainFunction.sc.next();
		switch (MainFunction.cmd) {
		case "x":
			break;
		}

		// 메서드 종료 시 반환 값
		return 0;
	}
}
