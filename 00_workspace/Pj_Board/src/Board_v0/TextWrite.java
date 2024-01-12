package Board_v0;

public class TextWrite extends MainFunction {

	// 글 작성 메서드
	public static int TextWriteRun() {
		int indexcode = MainFunction.texttitle.size() + 1;

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

			// 사용자로부터 제목 입력 받아서 배열과 데이터베이스에 저장
			MainFunction.cmd = MainFunction.sc.nextLine();
			String textTitle = MainFunction.cmd;
			

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
			Cw.wn("================================");
			Cw.wn("아래와 같이 작성을 완료하겠습니까?");
			Cw.wn("제목 : " + textTitle); // 글제목 출력
			Cw.wn("내용"); // 글내용 출력
			Cw.wn("--------------------------------");
			Cw.wn(textBody); // 글내용 출력
			Cw.wn("================================");
			Cw.wn("[y.네][n.아니요][x.이전메뉴로 돌아가기]");
			Cw.wn("================================");

			// 사용자 선택에 따른 분기
			MainFunction.cmd = MainFunction.sc.next();
			switch (MainFunction.cmd) {
			case "y":
				MainFunction.texttitle.add(new TitleData(textTitle));
				MainFunction.textbody.add(new BodyData(textBody));
				Db.dbHub("Other", "Insert into board(textnumber, b_title, b_datetime, b_hit, b_text, b_user) value (" + indexcode + ", '" + textTitle + "', now(), " + "0, '" + textBody + "')");
				Cw.wn("글이 성공적으로 저장되었습니다.");
				Cw.wn("이전 메뉴로 돌아갑니다.");
				MenuDisp.MenuRun();
			case "n":
				Cw.wn("글 작성을 취소합니다.");
				Cw.wn("이전 메뉴로 돌아갑니다.");
				MenuDisp.MenuRun();
			case "x":
				MenuDisp.MenuRun();
			}
		}
	}
}
