package P_Board.Data;

import P_Board.MySqlBoard.Join;

//아이디 데이터를 나타내는 클래스
public class IdData extends Join {
	// 아이디를 저장하는 문자열 변수
	public String id;

	// 생성자: 주어진 문자열을 아이디로 설정
	public IdData(String xx) {
		id = xx;
	}

	// 아이디 값을 반환하는 메서드
	public String getId() {
		return id;
	}
}
