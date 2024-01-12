
package Board_v0;

public class Main {
	public static void main(String[] args) {
		MainDisp m = new MainDisp();
		Db.dbHub("Other", "Delete from idpw");
		Db.dbHub("Other", "Delete from board");
		Db.dbInit();
		m.run();
	}
}