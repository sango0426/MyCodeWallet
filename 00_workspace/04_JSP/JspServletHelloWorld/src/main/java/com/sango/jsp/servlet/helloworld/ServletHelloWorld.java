package com.sango.jsp.servlet.helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Xx")
public class ServletHelloWorld extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");        // 안하면 한글 깨짐
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();
		if(id.equals("cat") && pw.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("id_key", id);
			session.setMaxInactiveInterval(30);
		}
		out.println("<a href='index2.jsp'>인덱스2</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
