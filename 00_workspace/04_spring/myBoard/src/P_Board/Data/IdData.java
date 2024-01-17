package P_Board.Data;

import P_Board.MySqlBoard.Join;

/**
 * IdData 클래스 - 아이디 데이터를 나타내는 클래스입니다.
 */
public class IdData extends Join {
	// 아이디를 저장하는 문자열 변수
	public String id;

	/**
	 * IdData 생성자
	 * 
	 * @param xx 초기 아이디 값
	 */
	public IdData(String xx) {
		id = xx;
	}

	/**
	 * 아이디 값을 반환하는 메서드
	 * 
	 * @return 아이디 값
	 */
	public String getId() {
		return id;
	}
}
