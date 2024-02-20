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
<title>게시판 - 글수정</title>
<link rel="stylesheet" href="../Css/common.css">
</head>
<body>
	<%
	String editNum = request.getParameter("num");
	String title = null;
	String id = null;
	String content = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_board", "root", "root");
		Statement st = con.createStatement();
		String sql = "SELECT * FROM board_guest where num = " + editNum;
		System.out.println("전송한 SQL : " + sql);
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		title = rs.getString("title");
		content = rs.getString("content");
		id = rs.getString("id");
	} catch(Exception e) {
		e.printStackTrace();
	}
	%>
	
	글번호 : <%=editNum %>
	
	<form action="modifyproc.jsp" method="get">
		<input name="num" type="hidden" value=<%=editNum %>>
		제목 : <input name="title" value=<%=title %>><br>
		작성자 : <input name="id" value=<%=id %>><br>
		내용 : <textarea name="content" value=<%=content %>></textarea><br>
		<input type="submit" value="글수정하기">
	</form>
</body>
</html>