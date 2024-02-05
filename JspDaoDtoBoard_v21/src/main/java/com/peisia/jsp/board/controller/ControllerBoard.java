package com.peisia.jsp.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.c.util.Cw;
import com.peisia.jsp.board.BoardListProcessor;
import com.peisia.jsp.board.dto.Dto;
import com.peisia.jsp.board.service.ServiceBoard;

@WebServlet("/board/*")
public class ControllerBoard extends HttpServlet {
	String category;
	String nextPage;
	ServiceBoard service;

	@Override
	public void init() throws ServletException {
		service = new ServiceBoard();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트가 전송한 category 파라미터를 받아온다.
		category = request.getParameter("category");

		// URL에서 추출한 액션 정보를 저장하는 변수
		String action = request.getPathInfo();
		Cw.wn("action:" + action);

		if (action != null) {
			switch (action) {
			// 삭제 액션 처리
			case "/del":
				nextPage = "/board/list"; // 리스트로 이동
				service.del(category, request.getParameter("no")); // 🐇서비스🐇: 삭제 기능 수행
				break;
			// 글쓰기 액션 처리
			case "/write":
				nextPage = "/board/list"; // 리스트로 이동
				Dto dto = new Dto(category, request.getParameter("title"), request.getParameter("id"),
						request.getParameter("text"));
				service.write(dto); // 🐇서비스🐇: 글쓰기 기능 수행
				break;
			// 수정 폼으로 이동
			case "/edit_insert":
				Cw.wn("수정-insert");
				nextPage = "/edit.jsp";
				// 수정할 글 정보를 읽어와서 request에 저장
				request.setAttribute("post", service.read(category, request.getParameter("no"))); // 🐇서비스🐇: 수정 기능
				break;
			// 수정 액션 처리
			case "/edit_proc":
				Cw.wn("수정-proc");
				nextPage = "/board/list"; // 리스트로 이동
				// 수정된 글 내용을 서비스에 전달
				service.edit(new Dto(request.getParameter("title"), request.getParameter("text")),
						request.getParameter("no")); // 🐇서비스🐇: 수정 기능 수행
				break;
			// 글 읽기 액션 처리
			case "/read":
				nextPage = "/read.jsp";
				// 읽은 글 정보를 request에 저장
				Dto d = service.read(category, request.getParameter("no")); // 🐇서비스🐇: 읽기 기능 수행
				request.setAttribute("post", d);
				break;
			// 글 목록 조회 액션 처리
			case "/list":
				nextPage = "/list.jsp";
				// 리스트 관련 각종 처리를 다 한 BoardListProcessor 객체를 request에 저장
				BoardListProcessor blp = service.list(category, request.getParameter("page"),
						request.getParameter("word")); // 🐇서비스🐇: 리스트 기능 수행
				request.setAttribute("blp", blp);
				break;
			}

			// 다음 페이지로 이동
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request, response);
		}
	}
}
