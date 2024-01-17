package P_Board.Data;

/**
 * PwData 클래스 - 패스워드 데이터를 나타내는 클래스입니다.
 */
public class PwData {
	// 패스워드를 저장하는 문자열 변수
	public String pw;

	/**
	 * PwData 생성자
	 * 
	 * @param xx 초기 패스워드 값
	 */
	public PwData(String xx) {
		pw = xx;
	}

	/**
	 * 패스워드 값을 반환하는 메서드
	 * 
	 * @return 패스워드 값
	 */
	public String getPw() {
		return pw;
	}
}