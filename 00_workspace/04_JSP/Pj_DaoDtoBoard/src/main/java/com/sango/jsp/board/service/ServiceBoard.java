package com.sango.jsp.board.service;

import java.util.HashMap;

import com.sango.jsp.board.BoardListProcessor;
import com.sango.jsp.board.dao.DaoBoard;
import com.sango.jsp.board.dto.Dto;

public class ServiceBoard {
	// DAO 객체를 사용하기 위한 선언
	DaoBoard dao;

	// 생성자에서 DAO 객체 초기화
	public ServiceBoard() {
		dao = new DaoBoard();
	}

	// 글 삭제 기능
	public void del(String num, String category) {
		dao.del(num, category);
	}

	// 글 쓰기 기능
	public void write(Dto d) {
		dao.insert(d);
	}

	// 글 읽기 기능
	public Dto read(String category, String num) {
		return dao.selectPost(category, num);
	}

	// 글 수정 기능
	public void edit(Dto d, String num) {
		dao.update(d, num);
	}
	
	// 로그인 기능
	public HashMap<String, String> login(Dto d) {
		return dao.login(d);
	}
	
	// 회원가입 기능
	public void join(String nickname, String id, String pw) {
		dao.join(nickname, id, pw);
	}

	// 글 목록 조회 기능
	public BoardListProcessor list(String category, String currentPage, String word) {
		// currentPage가 null이면 기본값으로 1 설정
		if (currentPage == null) {
			currentPage = "1";
		}
		// BoardListProcessor 객체 생성 및 반환
		return new BoardListProcessor(dao, category, currentPage, word);
	}
}
