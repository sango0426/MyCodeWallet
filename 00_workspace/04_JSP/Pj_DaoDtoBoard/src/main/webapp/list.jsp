<%@ page import="java.util.HashMap" %>
<%@ page import="com.sango.jsp.board.BoardListProcessor"%>
<%@ page import="com.sango.jsp.board.Board"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sango.jsp.board.dto.Dto"%>
<%@ page import="com.sango.jsp.board.dao.DaoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 리스트</title>
<link rel="stylesheet" href="/list.css">
</head>
<body>

<%
HashMap<String, String> userInfo = (HashMap<String, String>) session.getAttribute("userInfo");
BoardListProcessor blp = (BoardListProcessor)request.getAttribute("blp");
ArrayList<Dto> posts = blp.getPosts();
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
				<a href="/login.jsp"><button>로그인</button></a>
				<a href="/join.jsp"><button>회원가입</button></a>
			<%
			}
			%>
		</div>
	</div>
	<div id="mid">
		<div id="text_list">
			<div id="text_top">
				<div id="text_category">카테고리</div>
				<div id="text_num">번호</div>
				<div id="text_title">제목</div>
				<div id="text_nickname">글쓴이</div>
				<div id="text_datetime">등록일</div>
				<div id="text_hit">조회</div>
			</div>
			<div id="text_body">
				<div id="list_num">
					<hr>
					<%
					for (int i = 0; i < posts.size(); i++) { // 각 게시물에 고유한 클래스 추가
						String postClass = "post_" + i;
					%>
					<div class="<%=postClass%>">
						<div id="posts_category">
							<%=posts.get(i).category%>
						</div>
						<div id="posts_num">
							<%=posts.get(i).num%>
						</div>
						<div id="posts_title">
							<a href="/board/read?category=<%=blp.category%>&num=<%=posts.get(i).num%>"><%=posts.get(i).title%></a>
						</div>
						<div id="posts_nickname">
							<%=posts.get(i).nickname%>
						</div>
						<div id="posts_datetime">
							<%=posts.get(i).datetime%>
						</div>
						<div id="posts_hit">
							<%=posts.get(i).hit%>
						</div>
					</div>
					<hr>
					<%
					}
					%>
					<div id="write_toList">
						<div id="write">
							<a href="/write.jsp?category=<%=blp.category%>"><button>글쓰기</button></a>
						</div>
						<div id="toHome">
							<a href="/"><button>홈으로</button></a>
						</div>
					</div>
					<div id="pagingBlock">
						<%=blp.getHtmlPageList()%>
					</div>
					<div id="paging">
						<form aciton="/board/list">
							<div id="search">
								<input type="hidden" name="category" value="<%=blp.category%>">
								<input name="word" placeholder="검색할 단어를 입력해주세요.">
								<input type="submit" value="검색">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>