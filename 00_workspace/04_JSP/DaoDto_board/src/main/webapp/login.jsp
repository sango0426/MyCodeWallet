<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 회원가입</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<div id="wrapper">
		<div id="wrapper_top">
			<div id="wrpper_top_title">
				<img id="logo" src="tarkov.jpg">
			</div>
		</div>
		<hr>
		<div id="joinlist">
			<form action="/DaoDto_board/ServletLogin" method="post">
				아이디<input
					name="id" minlength='6' maxlength='16'
					placeholder="아이디 입력(6자리 이상 16자리 이하)"><br>
				비밀번호<input name="pw"
					type="password" minlength='6' maxlength='12'
					placeholder="비밀번호 입력(6자리 이상 12자리 이하)"><br>
				<input type="submit" value="로그인" id="loginbutton">
			</form>
		</div>
	</div>
</body>
</html>