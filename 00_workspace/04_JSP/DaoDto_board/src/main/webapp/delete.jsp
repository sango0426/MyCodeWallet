<%@ page import="java.util.ArrayList"%>
<%@ page import="DataProsess.Dao"%>
<%@ page import="DataProsess.Dto"%>
<%@ page import="DataProsess.Dto_member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 글삭제 처리</title>
</head>
<body>
	<%
	String num = request.getParameter("num");
	Dao dao = new Dao();
	dao.del(num);
	response.sendRedirect("list.jsp");
	%>
</body>
</html>