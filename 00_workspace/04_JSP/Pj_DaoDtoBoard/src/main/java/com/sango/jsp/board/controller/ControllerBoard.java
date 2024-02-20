package com.sango.jsp.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sango.c.util.Cw;
import com.sango.jsp.board.BoardListProcessor;
import com.sango.jsp.board.dto.Dto;
import com.sango.jsp.board.service.ServiceBoard;

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
		category = request.getParameter("category");

		String action = request.getPathInfo();
		Cw.wn("action : " + action);

		if (action != null) {
			switch (action) {
			// 삭제 액션 처리
			case "/del":
				nextPage = "/board/list"; // 리스트로 이동
				service.del(category, request.getParameter("num")); // 🐇서비스🐇: 삭제 기능 수행
				break;
			// 글쓰기 액션 처리
			case "/write":
				nextPage = "/board/list"; // 리스트로 이동
				Dto dto = new Dto(category, request.getParameter("title"), request.getParameter("nickname"),
						request.getParameter("text"));
				service.write(dto); // 🐇서비스🐇: 글쓰기 기능 수행
				break;
			// 수정 폼으로 이동
			case "/edit_insert":
				Cw.wn("수정-insert");
				nextPage = "/edit.jsp";
				// 수정할 글 정보를 읽어와서 request에 저장
				request.setAttribute("post", service.read(category, request.getParameter("num"))); // 🐇서비스🐇: 수정 기능
				break;
			// 수정 액션 처리
			case "/edit_proc":
				Cw.wn("수정-proc");
				nextPage = "/board/list"; // 리스트로 이동
				// 수정된 글 내용을 서비스에 전달
				service.edit(new Dto(request.getParameter("title"), request.getParameter("text")),
						request.getParameter("num")); // 🐇서비스🐇: 수정 기능 수행
				break;
			// 글 읽기 액션 처리
			case "/read":
				nextPage = "/read.jsp";
				// 읽은 글 정보를 request에 저장
				Dto d = service.read(category, request.getParameter("num")); // 🐇서비스🐇: 읽기 기능 수행
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
				
			// 로그인 액션 처리
			case "/login":
				nextPage = "/";
				HashMap<String, String> userInfo = service.login(new Dto(request.getParameter("id"), request.getParameter("pw"), request.getParameter("nickname")));
				if (!userInfo.isEmpty()) {
			        // 로그인 성공
					// 서블릿에서 HttpSession 가져오기
					HttpSession session = request.getSession();
			        session.setAttribute("userInfo", userInfo);
			        response.getWriter().println("로그인 성공!");
			        // 여기에서 로그인 성공 후 처리
			    } else {
			        // 로그인 실패
			        nextPage = "/login.jsp"; // 로그인 실패 시 로그인 페이지로 이동
			        response.getWriter().println("로그인 실패. 아이디와 비밀번호를 확인하세요.");
			    }
			    break;
			    
			// 회원가입 액션 처리   
			case "/join":
				nextPage = "/";
				service.join(request.getParameter("nickname"), request.getParameter("id"),
						request.getParameter("pw"));
			    break;
			}

			// 다음 페이지로 이동
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request, response);
		}
	}
}
