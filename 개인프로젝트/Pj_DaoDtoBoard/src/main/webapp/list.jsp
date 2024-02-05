<%@ page import="com.sango.jsp.board.BoardListProcessor"%>
<%@ page import="com.sango.jsp.board.Board"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sango.jsp.board.dto.Dto"%>
<%@ page import="com.sango.jsp.board.dao.DaoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타르코프 인벤 - 리스트</title>
<link rel="stylesheet" href="list.css">
</head>
<body>
<%
BoardListProcessor blp = (BoardListProcessor)request.getAttribute("blp"); 
ArrayList<Dto> posts = blp.getPosts();
%>
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
	<div id="menubar">
		<button id="tarkov_wiki_Button"
			onClick="location.href='https://escapefromtarkov.fandom.com/wiki/Escape_from_Tarkov_Wiki'">타르코프
			위키</button>
		<br>
	</div>
	<div id="mid">
		<div id="text_list">
			<div id="text_top">
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
					// 요청받은 현재 페이지 번호를 변수에 저장
					String pageNum = request.getParameter("page");

					// 페이지번호가 null()이면 pageNum 1로 설정
					if (pageNum == null) {
						pageNum = "1";
					}
					Dao dao = new Dao();

					// 총 페이지 초기화
					int totalPage = 0;

					// posts ArrayList 초기화
					ArrayList<Dto> posts = null;

					// 변수에 검색한 단어 저장
					String searchWord = request.getParameter("word");

					// 검색된 단어가 null(검색을 안했을때)이면 일반 리스트의 총 페이지 수
					if (searchWord == null || searchWord.equals("null")) {
						posts = dao.list(pageNum);
						totalPage = dao.getTotalPageCount();
					} else { // 검색된 단어가 있으면 검색된 리스트의 총 페이지 수
						posts = dao.listSearch(searchWord, pageNum);
						totalPage = dao.getSearchTotalPageCount(searchWord);
					}

					for (int i = 0; i < posts.size(); i++) { // 각 게시물에 고유한 클래스 추가
						String postClass = "post_" + i;
					%>
					<div class="<%=postClass%>">
						<div id="posts_num">
							<%=posts.get(i).num%>
						</div>
						<div id="posts_title">
							<a href="/board/read?category=<%=blp.category%>&no=<%=posts.get(i).num%>"><%=posts.get(i).title%></a>
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

					// int형으로 계산하기 위해 String형인 pageNum(현재 페이지)을 int형으로 변환하여 변수에 새로 저장
					int nPageNum = Integer.parseInt(pageNum);

					//🐿️🐿️🐿️{블럭 처리 - 1/9}.블럭 총 갯수 구하기🐿️🐿️🐿️//
					//블럭 총 갯수 = 페이지 수 / 블럭 당 페이지 수 << 결과에 올림 처리
					//참고: Math. 함수들 : 반올림(round), 올림(ceil), 버림(floor)
					int totalBlock = (int) Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT);

					//🐿️🐿️🐿️{블럭 처리 - 2/9}.현재 블럭 번호 구하기🐿️🐿️🐿️//
					//현재 블럭 번호 = 현재 페이지 번호 / 블럭 당 페이지 수 << 결과에 올림 처리
					int nowBlockNum = (int) Math.ceil((double) nPageNum / Board.PAGE_LINK_AMOUNT);

					//🐿️🐿️🐿️{블럭 처리 - 3/9}.블럭 시작 페이지 번호 구하기🐿️🐿️🐿️//
					//블럭 시작 페이지 번호 = (현재 블럭 번호 - 1) * 블럭 당 페이지 수 + 1
					int blockStartNum = (nowBlockNum - 1) * Board.PAGE_LINK_AMOUNT + 1;

					//🐿️🐿️🐿️{블럭 처리 - 4/9}.블럭 페이지 끝 번호 구하기🐿️🐿️🐿️//
					//블럭 페이지 끝 번호 = 현재 블럭 번호 * 블럭 당 페이지 수
					int blockEndNum = nowBlockNum * Board.PAGE_LINK_AMOUNT;

					//만약 블럭 마지막 페이지 번호가 전체 페이지 마지막 번호보다 큰경우에는 블럭 마지막 페이지번호를 페이지 마지막 번호로 저장하는 예외 처리 하기
					if (blockEndNum > totalPage) {
						blockEndNum = totalPage;
					}

					//🐿️🐿️🐿️{블럭 처리 - 5/9}.(이전/다음) 관련 초기화 처리🐿️🐿️🐿️ 
					//🐿️🐿️🐿️: 현재 블럭에서 이전/다음을 눌렀을 때 현재 페이지 값을 변경할 때 넣을 값을 일단 초기화하기🐿️🐿️🐿️//
					int nextPage = 0;
					int prevPage = 0;

					//🐿️🐿️🐿️{블럭 처리 - 6/9}.(이전/다음) 관련 계산 등 처리🐿️🐿️🐿️ 
					//🐿️🐿️🐿️: 현재 블럭에서 이전/다음이 가능한지 계산하고 가능 여부를 저장해두기🐿️🐿️🐿️//
					boolean hasNext = false;
					boolean hasPrev = false;

					// 이전 버튼 계산 처리
					if (nowBlockNum <= 1) {
						hasPrev = false;
						hasNext = false;
					} else {
						hasPrev = true;
						//🐿️🐿️🐿️: 이전 블럭 이동 시 몇 페이지로 이동할지 정하기🐿️🐿️🐿️//
						//이전 블럭의 마지막 페이지로 이동
						//공식 : (현재 블럭 번호 - 1) * 블럭 당 페이지 수
						prevPage = (nowBlockNum - 1)* Board.PAGE_LINK_AMOUNT;
					}
					// 다음 버튼 계산 처리(현재 블럭 번호가 전체 블록보다 작을 경우)
					if (nowBlockNum < totalBlock) {
						hasNext = true;
						//🐿️🐿️🐿️: 다음 블럭 이동 시 몇 페이지로 이동할지 정하기🐿️🐿️🐿️//
						//다음 블럭의 처음 페이지로 이동
						//공식 : 현재 블럭 번호 * 블럭 당 페이지수 + 1
						nextPage = nowBlockNum * Board.PAGE_LINK_AMOUNT + 1;
					} else {
						hasNext = false; //다음 블럭 가기 불가능
					}
					%>
					<div id="write_toList">
						<div id="write">
							<button id="write_button" onClick="location.href='write.jsp'">글쓰기</button>
						</div>
						<div id="toList">
							<button id="return_button" onClick="location.href='index.jsp'">리스트로</button>
						</div>
					</div>
					<div id="pagingBlock">
						<div id="prev_button">
							<%
							//🐿️🐿️🐿️{블럭 처리 - 7/9}.(이전/다음)의 (이전) 처리🐿️🐿️🐿️
							//🐿️🐿️🐿️: 이전 블럭 이동이 가능하면 미리 계산한 이전 블록 이동 시 이동 할 페이지번호를 랑크에 전달하기🐿️🐿️🐿️//
							if (hasPrev) {
								if (searchWord == null) { //일반 리스트
									%>
							<a href="index.jsp?page=<%=prevPage%>"><button class="button">이전</button></a>
							<%
								} else { //검색 리스트
										%>
							<a href="index.jsp?page=<%=prevPage%>&word=<%=searchWord%>"><button
									class="button">이전</button></a>
							<%	
								}
							} else {
								%>
							<button class="button disabled">이전</button>
							<%
							}
							%>
						</div>
						<div id="page_list">
							<%
							//🐿️🐿️🐿️{블럭 처리 - 8/9}.기존의 제한 없던 페이지리스트 나열을 ex.[1][2][3].....[n] 블럭 적용하기🐿️🐿️🐿️
							//🐿️🐿️🐿️현재 블럭의 페이지 시작번호와 끝번호를 이용하여 반복문의 시작값 끝값으로 하고 이 값을 페이지 번호로 출력하기🐿️🐿️🐿️//
							for (int i = blockStartNum; i <= blockEndNum; i++) {
								if (searchWord == null) {
									String listClass = "list_" + i;
									%>
							<div id=<%=listClass%>>
								<a href="index.jsp?page=<%=i%>"><%=i%></a>
							</div>
							<%
								} else {
									//*중요* 한글 검색어를 전달할 때는 url인코딩을 해줘야함. 영어는 괜찮음. 그래도 다 해주고..
									String urlEncodedSearchWord = java.net.URLEncoder.encode(searchWord);
									String listClass = "list_" + i;
									%>
							<div id=<%=listClass%>>
								<a href="index.jsp?page=<%=i%>&word=<%=searchWord%>"><%=i%></a>
							</div>
							<%
								}
							}
							%>
						</div>
						<div id="next_button">
							<%
							//🐿️🐿️🐿️{블럭 처리 - 9/9}.(이전/다음)의 (다음) 처리🐿️🐿️🐿️
							//🐿️🐿️🐿️: 다음 블럭 이동이 가능하면 미리 계산한 이전 블록 이동 시 이동 할 페이지번호를 랑크에 전달하기🐿️🐿️🐿️//
							if (hasNext) {
								if (searchWord == null) { //일반 리스트
									%>
							<a href="index.jsp?page=<%=nextPage%>"><button class="button">다음</button></a>
							<%
								} else {
									%>
							<a href="index.jsp?page=<%=nextPage%>&word=<%=searchWord%>"><button
									class="button">다음</button></a>
							<%
								}
							} else {
								%>
							<button class="button disabled">다음</button>
							<%
							}
							%>
						</div>
					</div>
					<div id="paging">
						<form aciton="index.jsp">
							<div id="search">
								<input name="word" placeholder="검색할 단어를 입력해주세요."> <input
									type="submit" value="검색">
							</div>
						</form>
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
</body>
</html>