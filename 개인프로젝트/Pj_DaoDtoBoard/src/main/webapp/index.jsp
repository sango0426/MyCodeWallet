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
	<div id="main_top">
		<div id="main_top_logo">
			<img src="./image/tarkovlogo.jpg">
		</div>
		<div id="main_top_title">
			<h1>타르코프 인벤</h1>
		</div>
		<div id="main_top_loginjoin">
			<a href="login.jsp"><button>로그인</button></a>
			<a href="join.jsp"><button>회원가입</button></a>
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
			<a href="/board/list?category=free"><button>공략게시판</button></a>
		</div>
		<div id="question">
			<a href="/board/list?category=free"><button>질문&답변</button></a>
		</div>
		<div id="tendinous">
			<a href="/board/list?category=free"><button>사이트 건의&제보</button></a>
		</div>
	</div>
</body>
</html>