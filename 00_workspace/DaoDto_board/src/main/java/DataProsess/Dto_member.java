package DataProsess;

public class Dto_member {
	public String nickname;
	public String id;
	public String pw;

	public Dto_member(String nickname, String id, String pw) {
		this.nickname = nickname;
		this.id = id;
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}
}
