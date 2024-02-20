<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 메인</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
<%
HashMap<String, String> userInfo = (HashMap<String, String>) session.getAttribute("userInfo");
%>
	<div id="main_top">
		<div id="main_top_logo">
			<a href="/"><img src="/image/tarkovlogo.jpg"></a>
		</div>
		<div id="main_top_title">
			<h1>타르코프 인벤</h1>
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
	
	<div id="main_body">
		<div id="notification">
			<a href="/board/list?category=notification"><button>공지게시판</button></a>
		</div>
		<div id="free">
			<a href="/board/list?category=free"><button>자유게시판</button></a>
		</div>
		<div id="walkthrough">
			<a href="/board/list?category=walkthrough"><button>공략게시판</button></a>
		</div>
		<div id="question">
			<a href="/board/list?category=question"><button>질문&답변</button></a>
		</div>
		<div id="tendinous">
			<a href="/board/list?category=tendinous"><button>사이트 건의&제보</button></a>
		</div>
		<div id="tarkov_wiki_Button">
			<a href="https://escapefromtarkov.fandom.com/wiki/Escape_from_Tarkov_Wiki"><button>타르코프 위키</button></a>
		</div>
	</div>
</body>
</html>