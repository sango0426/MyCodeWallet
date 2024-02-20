package P_Board.Data;

//패스워드 데이터를 나타내는 클래스
public class PwData {
	// 패스워드를 저장하는 문자열 변수
	public String pw;

	// 생성자: 주어진 문자열을 패스워드로 설정
	public PwData(String xx) {
		pw = xx;
	}

	// 패스워드 값을 반환하는 메서드
	public String getPw() {
		return pw;
	}
}
