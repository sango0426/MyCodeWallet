<%@ page import="java.util.ArrayList"%>
<%@ page import="DataProsess.Dao"%>
<%@ page import="DataProsess.Dto"%>
<%@ page import="DataProsess.Dto_member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
session = request.getSession(false);
String user = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 글읽기</title>
<link rel="stylesheet" href="read.css">
</head>
<body>
	<div id="wrapper">
		<div id="main_top">
			<div id="logo">
				<img src="tarkov.jpg">
			</div>
			<div id="advertisement">
				<a href="https://liesofp.inven.co.kr/"><img
					src="advertisement.jpg"></a>
			</div>
			<div id="login_join">
				<%
				if (session != null) {
				    user = (String) session.getAttribute("user");
				}
				
				if(user != null) {
				%>
					<%=user %>님, 어서오세요!
					<button id="login_Button" onClick="logoutUser()">로그아웃</button>
					<%
				} else {
				%>
					<button id="login_Button" onClick="location.href='login.jsp'">로그인</button>
					<button id="Join_Button" onClick="location.href='join.jsp'">회원가입</button>
				<%
				}
				%>
			</div>
		</div>
		<div id="mid">
			<div id="menubar">
				<button id="tarkov_wiki_Button"
					onClick="location.href='https://escapefromtarkov.fandom.com/wiki/Escape_from_Tarkov_Wiki'">타르코프
					위키</button>
			</div>
			<div id="text_list">
				<div id="text_body">
					<div id="list_num">
						<%
						String num = request.getParameter("num");
						Dao dao = new Dao();
						Dto d = dao.read(num);
						%>
						<div id="read_top">
							<div id="read_nickname"><%=d.nickname%></div>
							<div id="read_datetime"><%=d.datetime%></div>
							<div id="read_hit"><%=d.hit%></div>
						</div>
						<div id="read_title">
							<%=d.title%>
							<hr>
						</div>
						<div id="read_text">
							<%=d.text%>
						</div>
					</div>
					<div id="body_button">
						<button id="edit_button" onClick="location.href='edit.jsp'">글수정</button>
						<button id="delete_button" onClick="location.href='delete.jsp'">글삭제</button>
						<button id="return_button" onClick="location.href='index.jsp'">이전으로</button>
					</div>
				</div>
			</div>
		</div>
		<script>
			function logoutUser() {
				// 로그아웃 처리 후 세션 초기화
				<%session.invalidate();%>
				// 로그아웃 후 페이지 새로고침
				location.reload();
			}
		</script>
	</div>
</body>
</html>