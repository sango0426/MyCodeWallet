<%@ page import="java.util.HashMap" %>
<%@ page import="com.sango.jsp.board.dto.Dto"%>
<%@ page import="com.sango.jsp.board.dao.DaoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 글 읽기</title>
<link rel="stylesheet" href="read.css">
</head>
<body>
<%
HashMap<String, String> userInfo = (HashMap<String, String>) session.getAttribute("userInfo");
Dto d=(Dto)request.getAttribute("post");
String category = request.getParameter("category");
%>
<div id="wrapper">
	<div id="main_top">
		<div id="logo">
			<a href="/"><img src="/image/tarkovlogo.jpg"></a>
		</div>
		<div id="advertisement">
			<a href="https://liesofp.inven.co.kr/"><img src="/image/advertisement.jpg"></a>
		</div>
		<div id="main_top_userInfo">
			<%
			if (userInfo != null) {
			    // 로그인된 경우
			    String userNickname = userInfo.get("nickname");
			%>
			    <div id="user">
			    어서오세요! <%=userNickname %>님!
			    </div>
			<%
			} else {
			%>
				<a href="login.jsp"><button>로그인</button></a>
				<a href="join.jsp"><button>회원가입</button></a>
			<%
			}
			%>
		</div>
	</div>
	<div id="posts">
		<div id="posts_num"><%=d.num%></div>
		<div id="posts_category"><%=d.category%></div>
		<div id="posts_title"><%=d.title%></div><br>
		<hr>
		<div id="posts_title"><%=d.text%></div><br>
		<hr>
	</div>
	<div class="button">
		<%
		if(userInfo == null) {
		%>
			<div id="toList_button"><a href="/board/list?category=<%=category%>">리스트로</a></div>
			<div id="home_button"><a href="/">홈으로</a></div>
		<%	
		} else {
		%>
			<div id="del_button"><a href="/board/del?category=<%=category%>&num=<%=d.num%>">삭제</a></div>
			<div id="edit_button"><a href="/board/edit_insert?category=<%=category%>&num=<%=d.num%>">수정</a></div>
			
		<%
		}
		%>	
	</div>
</div>
</body>
</html>