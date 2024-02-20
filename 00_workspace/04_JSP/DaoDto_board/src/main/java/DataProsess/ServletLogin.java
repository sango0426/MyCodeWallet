package DataProsess;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");
		Dao dao = new Dao();
		Dto_member loginUser = dao.login(userId, userPw);
		if (loginUser != null) {
	        if (userId.equals(loginUser.getId()) && userPw.equals(loginUser.getPw())) {
	            // 로그인 성공 시 세션에 사용자 정보 저장
	            HttpSession session = request.getSession();
	            session.setAttribute("user", loginUser.getNickname());
	            System.out.println("로그인 성공 : " + loginUser.getNickname());
	            response.sendRedirect("index.jsp");
	        } else {
	            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
	            response.sendRedirect("login.jsp"); // 실패 시 로그인 페이지로 리다이렉트
	        }
	    } else {
	        System.out.println("로그인 실패 : 사용자 정보를 가져오지 못했습니다.");
	        response.sendRedirect("login.jsp"); // 실패 시 로그인 페이지로 리다이렉트
	    }
	}
}
