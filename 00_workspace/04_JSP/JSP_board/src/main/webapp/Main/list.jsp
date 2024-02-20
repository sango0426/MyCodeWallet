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
<title>게시판 - 글리스트</title>
<link rel="stylesheet" href="../Css/common.css">
</head>
<body>
	글번호 | 제목 | 글내용 | 작성자id
	<hr>
	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_board", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * From board_guest");
		while(rs.next()) {
			String num = rs.getString("num");	
			String title = rs.getString("title");	
			String id = rs.getString("id");	
			String content = rs.getString("content");	
		
	%>
	<%=num %>
	<a href="read.jsp?num=<%=num%>"><%=title %></a>
	<%=content %>
	<%=id %><br>
	
	<%
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	%>
	<a href="write.jsp">글쓰기</a>
</body>
</html>