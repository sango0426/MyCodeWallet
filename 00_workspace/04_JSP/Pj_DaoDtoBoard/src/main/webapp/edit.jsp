<%@ page import="com.sango.jsp.board.dto.Dto"%>
<%@ page import="com.sango.jsp.board.dao.DaoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 글수정</title>
<link rel="stylesheet" href="edit.css">
</head>
<body>
<%
Dto dto = (Dto)request.getAttribute("post");	//글 가져오기
String category = request.getParameter("category");
%>
<div id="main_top">
		<div id="logo">
			<a href="/"><img src="/image/tarkovlogo.jpg"></a>
		</div>
		<div id="advertisement">
			<a href="https://liesofp.inven.co.kr/"><img src="/image/advertisement.jpg"></a>
		</div>
		<div id="login_join">
			<button id="login_Button" onClick="location.href='login.jsp'">로그인</button>
			<button id="Join_Button" onClick="location.href='join.jsp'">회원가입</button>
		</div>
	</div>
	<form action="/board/write">
		<div id="textbody">
			<input type="hidden" name="category" value="<%=category%>">
			<input type="hidden" name="num" value="<%=dto.num%>">
			<div id="input_title">
				제목
				<hr>
				<input name="title" placeholder="제목을 입력하세요."><br>
			</div>
			<div id="input_content">
				내용<br>
				<hr>
				<textarea name="text" placeholder="내용을 입력하세요."></textarea>
			</div>
		</div>
		<div id="bottom">
			<input type="submit" value="등록하기">
		</div>
	</form>
</body>
</html>