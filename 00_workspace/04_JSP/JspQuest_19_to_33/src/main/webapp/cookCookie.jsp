<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	String cookieName = "myCookie"; // 쿠키 이름 변수에 저장
	Cookie cookie = new Cookie(cookieName, "Apple"); // 쿠키 생성(쿠키이름 : myCookie, 쿠키 값 : Apple)
	cookie.setMaxAge(60);	// 초 단위. 1분
	cookie.setValue("Melone"); // 쿠키 값을 Melone으로 변경
	response.addCookie(cookie); // 쿠키를 클라이언트로 전달(아직 전달안됨. 이 웹페이지를 사용자가 브라우저로 다운로드해야 저장됨.)
	%>

	쿠키 구웠음<br>
	쿠키 내용은 <a href="tasteCookie.jsp">여기로!!!</a>
</body>
</html>