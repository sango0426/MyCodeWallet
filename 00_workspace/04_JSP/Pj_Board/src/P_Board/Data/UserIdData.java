package P_Board.Data;

public class UserIdData {
	// 아이디를 저장하는 문자열 변수
		public int userid;

		// 생성자: 주어진 문자열을 아이디로 설정
		public UserIdData(int xx) {
			userid = xx;
		}

		// 아이디 값을 반환하는 메서드
		public int getId() {
			return userid;
		}
}
