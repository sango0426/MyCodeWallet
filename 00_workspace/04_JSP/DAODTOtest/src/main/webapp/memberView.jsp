<%@ page import="java.util.ArrayList" %>

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
	MemberDAO memberDAO = new MemberDAO();
	ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
	
	for(int i = 0; i < dtos.size(); i++) {
		MemberDTO dto = dtos.get(i);
		String num = dto.getNum();
		String title = dto.getTitle();
		String content = dto.getContent();
		String id = dto.getId();
		
		out.println("번호 : " + num);
		out.println("제목 : " + title);
		out.println("내용 : " + content);
		out.println("작성자 : " + id);
	}
	%>
</body>
</html>