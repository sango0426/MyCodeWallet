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
<title>타르코프 인벤 - 글쓰기</title>
<link rel="stylesheet" href="write.css">
</head>
<body>
	<div id="main_top">
		<div id="logo">
			<a href="index.jsp"><img src="tarkov.jpg"></a>
		</div>
		<div id="advertisement">
			<a href="https://liesofp.inven.co.kr/"><img
				src="advertisement.jpg"></a>
		</div>
		<div id="login_join">
			<button id="login_Button" onClick="location.href='login.jsp'">로그인</button>
			<button id="Join_Button" onClick="location.href='join.jsp'">회원가입</button>
		</div>
	</div>
	<form action="/DaoDto_board/ServletWrite">
		<div id="textbody">
			<div id="input_title">
				제목
				<hr>
				<input name="title" placeholder="제목을 입력하세요."><br>
			</div>
			<div id="input_content">
				내용<br>
				<hr>
				<textarea name="content" placeholder="내용을 입력하세요."></textarea>
			</div>
		</div>
		<div id="bottom">
			<input type="submit" value="등록하기">
		</div>
	</form>
</body>
</html>