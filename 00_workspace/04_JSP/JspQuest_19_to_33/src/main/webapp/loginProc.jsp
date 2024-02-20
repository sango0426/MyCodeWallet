<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	System.out.println("아이디 : " + id);
	System.out.println("패스워드 : " + pw);
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYSQL_QUEST", "root", "root");
		System.out.println("성공");
		
		stmt=con.createStatement();
		
		rs = stmt.executeQuery("SELECT * FROM member where id='"+id+"'");
		rs.next();
		String checkPw = rs.getString("pw");
		System.out.println("패스워드 체크 : " + checkPw);
		
		if(pw.equals(checkPw)){
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		stmt.close();
		con.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>