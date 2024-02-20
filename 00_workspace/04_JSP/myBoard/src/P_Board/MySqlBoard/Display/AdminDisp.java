package P_Board.MySqlBoard.Display;

import P_Board.MySqlBoard.AdminMember;
import P_Board.MySqlBoard.AdminTextDelete;
import P_Board.MySqlBoard.AdminTextWrite;
import P_Board.MySqlBoard.Login;
import P_Board.MySqlBoard.MainFunction;
import P_Board.MySqlBoard.TextDelete;
import P_Board.MySqlBoard.TextFix;
import P_Board.MySqlBoard.TextList;
import P_Board.MySqlBoard.TextRead;
import P_Board.MySqlBoard.TextWrite;
import P_Board.Util.Cw;

/**
 * AdminDisp 클래스 - 관리자 전용 메뉴를 나타내는 클래스입니다.
 */
public class AdminDisp {
	/**
	 * 메뉴 실행 메서드
	 */
	public static void adminRun() {
		menu1: while (true) {
			// 메뉴 출력
			Cw.wn("===========================================");
			Cw.wn("메뉴를 선택해주세요!");
			Cw.wn("[1]글리스트/[2]글삭제/[3]글작성");
			Cw.wn("[4]회원 관리/[x]로그아웃");
			MainFunction.cmd = MainFunction.sc.next();

			// 사용자 메뉴 선택에 따른 분기
			switch (MainFunction.cmd) {
			case "1":
				// 글 리스트 기능 호출
				TextList.TextListRun();
				continue menu1;
			case "2":
				// 관리자 전용 글 삭제 기능 호출
				AdminTextDelete.adminTextDeleteRun();
				continue menu1;
			case "3":
				// 관리자 전용 글 쓰기 기능 호출
				AdminTextWrite.AdminTextWriteRun();
				continue menu1;
			case "4":
				// 관리자 전용 회원 관리 기능 호출
				AdminMember.AdminMemberRun();
				continue menu1;
			case "x":
				// 로그아웃
				Cw.wn("---------------------");
				Cw.wn("로그아웃합니다.");
				MainDisp.run();
			}
		}
	}
}