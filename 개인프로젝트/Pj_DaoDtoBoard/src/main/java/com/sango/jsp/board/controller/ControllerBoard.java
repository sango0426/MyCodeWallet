package com.sango.jsp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
