package Board_v0;

public class TextDelete {
	public static int TextDeleteRun() {
		Cw.wn("===================================");
		Cw.wn("현재 게시판에 등록된 글리스트입니다.");
		Cw.wn("삭제를 원하시는 리스트의 번호를 입력해주세요.");
		Cw.wn("===================================");
		while (true) {
			// 게시글 리스트 출력
			displayTextList();

			// 사용자로부터 번호 입력 받기
			MainFunction.cmd = MainFunction.sc.next();
			MainFunction.sc.nextLine(); // 엔터를 소비하기 위해 추가

			int selectedNum = Integer.parseInt(MainFunction.cmd);
			// 선택한 번호의 글 삭제
			if (deleteText(selectedNum)) {
				Cw.wn("=================================");
				Cw.wn("게시글 삭제 완료");
				Cw.wn("=================================");

				// 삭제 후 게시글 리스트 다시 출력
				displayTextList();
			} else {
				// 잘못된 번호 입력 시 메시지 출력
				Cw.wn("잘못된 번호를 입력하셨습니다.");
			}

			Cw.wn("=================================");
			Cw.wn("메인 메뉴로 돌아가시려면 x를 누르세요");
			Cw.wn("=================================");

			// 사용자로부터 메인 메뉴로 돌아가기 여부 입력 받기
			MainFunction.cmd = MainFunction.sc.next();
			switch (MainFunction.cmd) {
			case "x":
				return 0;
			}
		}
	}

	// 게시글 리스트를 화면에 출력하는 메서드
	private static void displayTextList() {
		int listNum = 0;
		int size = Math.min(MainFunction.texttitle.size(), MainFunction.textbody.size());
		for (int i = 0; i < size; i++) {
			listNum++;
			Cw.wn("=================================");
			Cw.wn("번호 : " + listNum);
			Cw.wn("제목 : " + MainFunction.texttitle.get(i).getTitle());
			Cw.wn("=================================");
		}
	}

	// 선택한 번호의 글을 삭제하는 메서드
	private static boolean deleteText(int selectedNum) {
		int size = Math.min(MainFunction.texttitle.size(), MainFunction.textbody.size());
		if (selectedNum > 0 && selectedNum <= size) {
			// 선택한 번호의 글 삭제
			MainFunction.texttitle.remove(selectedNum - 1);
			MainFunction.textbody.remove(selectedNum - 1);

			// 삭제 성공
			return true;
		}
		// 삭제 실패 (잘못된 번호 입력)
		return false;
	}
}
