package P_Board.Data;

/**
 * UserIdData 클래스 - 사용자 아이디 데이터를 나타내는 클래스입니다.
 */
public class UserIdData {
	// 아이디를 저장하는 정수 변수
	public int userid;

	/**
	 * UserIdData 생성자
	 * 
	 * @param xx 초기 사용자 아이디 값
	 */
	public UserIdData(int xx) {
		userid = xx;
	}

	/**
	 * 사용자 아이디 값을 반환하는 메서드
	 * 
	 * @return 사용자 아이디 값
	 */
	public int getId() {
		return userid;
	}
}