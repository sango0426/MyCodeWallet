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
	Cookie [] cookies = request.getCookies(); // cookies라는 변수에 전달된 쿠키들을 저장
	System.out.println("쿠키길이:"+cookies.length); // 쿠키 길이 출력
	if(cookies!=null){ // 쿠키 값이 비어있지 않을때
		for(int i=0; i<cookies.length; i++){ // 쿠키의 길이만큼 반복문 동작
			if(cookies[i].getName().equals("myCookie")){ // 쿠키의 이름에 myCookie가 포함이 되있으면
	%>
				쿠키 이름: <%=cookies[i].getName() %> <!-- 쿠키 이름 출력 -->
				쿠키 값: <%=cookies[i].getValue() %>	<!-- 쿠키 값 출력 -->

	<%				
			}
		}
	}
	%>
</body>
</html>