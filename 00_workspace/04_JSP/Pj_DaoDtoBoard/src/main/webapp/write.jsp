<%@ page import="java.util.HashMap" %>
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
<%
HashMap<String, String> userInfo = (HashMap<String, String>) session.getAttribute("userInfo");
	String category = request.getParameter("category");
%>
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
	<form action="/board/write">
		<div id="textbody">
			<input type="hidden" name="category" value="<%=category%>">
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