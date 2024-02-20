
package P_Board.MySqlBoard;

import P_Board.MySqlBoard.Display.MainDisp;
import P_Board.Util.Db;

public class Main {
	public static void main(String[] args) {
		MainDisp m = new MainDisp();
		Db.dbHub("Other", "Delete from idpw");
		Db.dbHub("Other", "Delete from board");
		Db.dbInit();
		m.run();
	}
}