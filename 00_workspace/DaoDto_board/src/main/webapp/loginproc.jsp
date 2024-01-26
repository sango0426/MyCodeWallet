<%@ page import="DataProsess.Dao" %>
<%@ page import="DataProsess.Dto_member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<%
Dto_member dto = new Dto_member(
    request.getParameter("nickname"),
    request.getParameter("id"),
    request.getParameter("pw")
);
Dao dao = new Dao();
Dto_member loggedInUser = dao.login(dto);
if (loggedInUser != null) {
    // 로그인 성공 시 세션에 유저 정보 저장
    session.setAttribute("user", loggedInUser);
    response.sendRedirect("index.jsp");
} else {
    // 로그인 실패 시 처리 (예: 다시 로그인 화면으로 리다이렉트)
    response.sendRedirect("login.jsp");
}
%>
</body>
</html>
