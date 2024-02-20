package com.sango.jsp.board.dto;

public class Dto {
	public String category;
	public String num;
	public String title;
	public String nickname;
	public String datetime;
	public String hit;
	public String text;       
	public String replyCount;
	public String replyOri;
	public String id;
	public String pw;
	
	public Dto(String category, String title, String nickname, String text) {
		this.category = category;
		this.title = title;
		this.nickname = nickname;
		this.text = text;
	}
	
	public Dto(String category, String num, String title, String nickname, String datetime, String hit, String text, String replyCount,
			String replyOri) {
		this.category = category;
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
	
	public Dto(String nickname, String id, String pw) {
		this.nickname = nickname;
		this.id = id;
		this.pw = pw;
	}
}
