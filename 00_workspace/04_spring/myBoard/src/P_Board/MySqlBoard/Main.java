package P_Board.MySqlBoard;

import P_Board.MySqlBoard.Display.MainDisp;
import P_Board.Util.Db;

public class Main {
	public static void main(String[] args) {

		// MainDisp 클래스의 인스턴스 생성
		MainDisp m = new MainDisp();

		// 데이터베이스에서 idpw, board, reply 테이블의 모든 데이터 삭제
		Db.dbHub("Other", "Delete from idpw");
		Db.dbHub("Other", "Delete from board");
		Db.dbHub("Other", "Delete from reply");

		// 데이터베이스 초기화
		Db.dbInit();

		// MainDisp의 run 메서드 실행하여 프로그램 시작
		m.run();
	}
}