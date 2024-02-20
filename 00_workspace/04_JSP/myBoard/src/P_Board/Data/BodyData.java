package P_Board.Data;

/**
 * BodyData 클래스 - 게시물의 본문 내용을 저장하는 데이터 클래스입니다.
 */
public class BodyData {
	public String textBody;

	/**
	 * BodyData 생성자
	 * 
	 * @param xx 초기 본문 내용
	 */
	public BodyData(String xx) {
		textBody = xx;
	}

	/**
	 * 본문 내용을 반환하는 메서드
	 * 
	 * @return 본문 내용
	 */
	public String getBody() {
		return textBody;
	}

	/**
	 * 본문 내용을 설정하는 메서드
	 * 
	 * @param newBody 새로운 본문 내용
	 */
	public void setBody(String newBody) {
		textBody = newBody;
	}
}