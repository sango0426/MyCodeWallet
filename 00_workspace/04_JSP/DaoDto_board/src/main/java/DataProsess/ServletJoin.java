package DataProsess;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletJoin")
public class ServletJoin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dto_member dto = new Dto_member(
				request.getParameter("nickname"),
				request.getParameter("id"),
				request.getParameter("pw")
		);
		Dao dao = new Dao();
		dao.join(dto);
		response.sendRedirect("index.jsp");
	}
}
