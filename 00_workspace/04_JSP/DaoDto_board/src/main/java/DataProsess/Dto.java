package DataProsess;
public class Dto {
	public String num;
	public String title;
	public String nickname;
	public String datetime;
	public String hit;
	public String text;
	public String replyCount;
	public String replyOri;

	public Dto(String title, String nickname, String text) {
		this.title = title;
		this.nickname = nickname;
		this.text = text;
	}

	// alt + shift + s 코드 자동 삽입
	public Dto(String num, String title, String nickname, String datetime, String hit, String text, String replyCount,
			String replyOri) {
		this.num = num;
		this.title = title;
		this.nickname = nickname;
		this.datetime = datetime;
		this.hit = hit;
		this.text = text;
		this.replyCount = replyCount;
		this.replyOri = replyOri;
	}

	public Dto(String title, String text) {
		this.title = title;
		this.text = text;
	}
}