package P_Board.Data;

/**
 * TitleData 클래스 - 제목 데이터를 나타내는 클래스입니다.
 */
public class TitleData {
	public String textTitle;

	/**
	 * TitleData 생성자
	 * 
	 * @param xx 초기 제목 값
	 */
	public TitleData(String xx) {
		textTitle = xx;
	}

	/**
	 * 제목 값을 반환하는 메서드
	 * 
	 * @return 제목 값
	 */
	public String getTitle() {
		return textTitle;
	}

	/**
	 * 제목 값을 설정하는 메서드
	 * 
	 * @param newTitle 새로운 제목 값
	 */
	public void setTitle(String newTitle) {
		textTitle = newTitle;
	}
}