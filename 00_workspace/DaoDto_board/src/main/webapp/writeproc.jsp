<%@ page import="java.util.ArrayList" %>
<%@ page import="DataProsess.Dao" %>
<%@ page import="DataProsess.Dto" %>
<%@ page import="DataProsess.Dto_member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 글쓰기 처리</title>
</head>
<body>
	<%
	Dto dto = new Dto(
			request.getParameter("title"),
			request.getParameter("content")
			);
	Dao dao = new Dao();
	dao.write(dto);
	response.sendRedirect("index.jsp");
	%>
</body>
</html>