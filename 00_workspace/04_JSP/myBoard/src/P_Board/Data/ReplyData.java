package P_Board.Data;

/**
 * ReplyData 클래스 - 댓글 데이터를 나타내는 클래스입니다.
 */
public class ReplyData {
	public String textReply;

	/**
	 * ReplyData 생성자
	 * 
	 * @param xx 초기 댓글 내용
	 */
	public ReplyData(String xx) {
		textReply = xx;
	}

	/**
	 * 댓글 내용을 반환하는 메서드
	 * 
	 * @return 댓글 내용
	 */
	public String getReply() {
		return textReply;
	}

	/**
	 * 댓글 내용을 설정하는 메서드
	 * 
	 * @param newReply 새로운 댓글 내용
	 */
	public void setReply(String newReply) {
		textReply = newReply;
	}
}