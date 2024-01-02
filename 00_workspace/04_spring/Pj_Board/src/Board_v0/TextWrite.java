package Board_v0;

public class TextWrite {

	// 글 작성 메서드
	public static int TextWriteRun() {
		int listNum = 0;

		// 사용자에게 글 작성 주의사항 안내
		Cw.wn("===========================");
		Cw.wn("글 작성");
		Cw.wn("글 작성시 주의사항");
		Cw.wn("빈줄상태로 엔터를 누르면 글 작성이 완료됨!");
		Cw.wn("===========================");

		// 글 작성 루프
		textWrite: while (true) {
			MainFunction.sc.nextLine(); // 엔터 소진
			Cw.wn("제목을 입력하세요.");
			Cw.wn("===========================");

			// 사용자로부터 제목 입력 받기
			MainFunction.cmd = MainFunction.sc.nextLine();
			String textTitle = MainFunction.cmd;
			MainFunction.texttitle.add(new TitleData(textTitle));

			// 여러 줄 입력 받기
			Cw.wn("내용을 입력하세요. (빈줄로 종료)");
			StringBuilder textBodyBuilder = new StringBuilder();
			while (true) {
				MainFunction.cmd = MainFunction.sc.nextLine();
				if (MainFunction.cmd.isEmpty()) {
					break;
				}
				textBodyBuilder.append(MainFunction.cmd).append("\n");
			}
			String textBody = textBodyBuilder.toString().trim();
			MainFunction.textbody.add(new BodyData(textBody));

			// 글번호 증가
			listNum++;

			// 글 작성 완료 메시지 및 작성된 글 정보 출력
			Cw.wn("================================");
			Cw.wn("글 작성 완료.");
			Cw.wn("번호 : " + listNum); // 글번호 출력
			Cw.wn("제목 : " + textTitle); // 글제목 출력
			Cw.wn("내용 : " + textBody); // 글내용 출력
			Cw.wn("================================");

			// 사용자에게 다음 동작 선택지 제공
			Cw.wn("[r.게시글 또 작성하기][x.이전메뉴로 돌아가기]");
			Cw.wn("================================");

			// 사용자 선택에 따른 분기
			MainFunction.cmd = MainFunction.sc.next();
			switch (MainFunction.cmd) {
			case "r":
				continue textWrite;
			case "x":
				break textWrite;
			}
		}

		// 작성된 글 목록 출력
		int size = Math.min(MainFunction.texttitle.size(), MainFunction.textbody.size());
		for (int i = 0; i < size; i++) {
			Cw.wn("글번호 : " + (i + 1) + " 제목 : " + MainFunction.texttitle.get(i).getTitle());
			Cw.wn(" 내용 : " + MainFunction.textbody.get(i).getBody());
		}

		// 이전 메뉴로 돌아감
		Cw.wn("이전 메뉴로 돌아갑니다!");
		Cw.wn("================================");

		// 메서드 종료 시 반환 값
		return 0;
	}
}
