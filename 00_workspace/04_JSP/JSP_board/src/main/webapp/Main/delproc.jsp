<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제 처리</title>
</head>
<body>
	<%
	String delNum = request.getParameter("num");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_board", "root", "root");
		Statement st = con.createStatement();
		String sql = "DELETE FROM board_guest where num = " + delNum;
		System.out.println("전송한 SQL : " + sql);
		int resultCount = st.executeUpdate(sql);
		if(resultCount == 1) {
			System.out.println("글삭제 성공");
		} else {
			System.out.println("글삭제 실패");
		}
		response.sendRedirect("list.jsp");
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>