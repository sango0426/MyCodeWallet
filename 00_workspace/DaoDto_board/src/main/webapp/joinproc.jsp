<%@ page import="DataProsess.Dao" %>
<%@ page import="DataProsess.Dto_member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>
	<%
	Dto_member dto = new Dto_member(
			request.getParameter("nickname"),
			request.getParameter("id"),
			request.getParameter("pw")
	);
	Dao dao = new Dao();
	dao.join(dto);
	response.sendRedirect("index.jsp");
	%>
</body>
</html>