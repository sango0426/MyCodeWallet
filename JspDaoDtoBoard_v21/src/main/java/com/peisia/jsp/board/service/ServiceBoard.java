package com.peisia.jsp.board.service;

import com.peisia.jsp.board.BoardListProcessor;
import com.peisia.jsp.board.dao.DaoBoard;
import com.peisia.jsp.board.dto.Dto;

// 게시판 서비스 클래스
public class ServiceBoard {

	// DAO 객체를 사용하기 위한 선언
	DaoBoard dao;

	// 생성자에서 DAO 객체 초기화
	public ServiceBoard() {
		dao = new DaoBoard();
	}

	// 글 삭제 기능
	public void del(String category, String no) {
		dao.del(category, no); // DAO의 글 삭제 메서드 호출
	}

	// 글 쓰기 기능
	public void write(Dto d) {
		dao.insert(d); // DAO의 글 쓰기 메서드 호출
	}

	// 글 읽기 기능
	public Dto read(String category, String no) {
		return dao.selectPost(category, no); // DAO의 글 읽기 메서드 호출
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

	// 글 수정 기능
	public void edit(Dto d, String no) {
		dao.update(d, no); // DAO의 글 수정 메서드 호출
	}
}
