package DataProsess;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletWrite")
public class ServletWrite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dto dto = new Dto(
				request.getParameter("title"),
				request.getParameter("id"),
				request.getParameter("text")
				);
		Dao dao = new Dao();
		dao.write(dto);
		response.sendRedirect("index.jsp");
	}
}
