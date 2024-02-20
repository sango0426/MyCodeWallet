package DataProsess;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import java.sql.Statement;

public class Dao extends Da{
	/* (1/5)삭제 */
	public void del(String num) {
		super.connect();	//conect()라고 해도 됨.	//[고정1,2,3]
//		connect();
		String sql = String.format("delete from %s where b_num=%s"
				,Db.TABLE_PS_BOARD_FREE, num);
		super.update(sql);
		super.close();	//[고정4,5]
	}

	/* (2/5)쓰기 */
	public void write(Dto d) {
		super.connect();	//[고정1,2,3]
		String sql = String.format(
				"insert into %s (b_title, b_text) values ('%s','%s')"
				,Db.TABLE_PS_BOARD_FREE, d.title, d.text);
		super.update(sql);
		super.close();	//[고정4,5]
	}
	/* (3/5)글 읽기 */
	public Dto read(String num) {
		super.connect();
		//[고정1,2,3]
		Dto post = null;
		try {
			
			//여기에 코딩하시오:
			String sql = String.format("select * from %s where b_num = %s", Db.TABLE_PS_BOARD_FREE, num);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("B_NUM"),
					rs.getString("B_TITLE"),
					rs.getString("B_NICKNAME"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return post;
	}	
	/* (4/5)글 리스트 */
	public ArrayList<Dto> list(String page) {
		super.connect();	//[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<>();
		try {
			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT;
			
			//여기에 코딩하시오:
			String sql = String.format("select * from %s limit %s, %s", Db.TABLE_PS_BOARD_FREE, startIndex, Board.LIST_AMOUNT);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NUM"),
						rs.getString("B_TITLE"),
						rs.getString("B_NICKNAME"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return posts;
	}
	/* (5/5)수정 */
	public void edit(Dto d,String num) {
		super.connect();	//[고정1,2,3]
		String sql = String.format(
				"update %s set b_title = '%s',b_text = '%s' where b_num = %s"
				,Db.TABLE_PS_BOARD_FREE, d.title,d.text,num);
		super.update(sql);
		super.close();	//[고정4,5]
	}

	// (생략) 회원 가입, 로그인, 회원 목록 조회 등의 메서드도 구현되어 있음
	// 중복되는 주석은 생략하고, 새로운 메서드에 대한 주석을 추가해야 함

	/* 회원 가입 */
	public void join(Dto_member d) {
		super.connect();
		try {
			// SQL 쿼리 실행하여 회원 가입
			String sql = String.format("insert into %s (b_nickname, b_id, b_pw) values ('%s','%s','%s')",
					Db.TABLE_MEMBER, d.nickname, d.id, d.pw);
			super.update(sql);
			
			// 자원 정리
			super.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 로그인 */
	public Dto_member login(String id, String pw) {
		super.connect();
		Dto_member loginUser = new Dto_member("", "", "");
		try {
			// SQL 쿼리 실행하여 로그인
			String sql = String.format("SELECT * FROM %s where b_id = '%s'", Db.TABLE_MEMBER, id);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
		        loginUser = new Dto_member(
		        	(String) rs.getObject("B_NICKNAME"),
		        	(String) rs.getObject("B_ID"),
		        	(String) rs.getObject("B_PW")
		        	);
		        System.out.println(loginUser.getNickname());
		        // 비밀번호 일치 여부 확인
		     // 비밀번호 일치 여부 확인
                if (pw.equals(loginUser.getPw())) {
                    // 비밀번호 일치하면 loginUser 리턴
                    return loginUser;
                } else {
                	loginUser = null;
                }
		    }

			// 자원 정리
			super.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginUser;
	}

	/* 회원 목록 조회 */
	public ArrayList<Dto_member> members() {
		super.connect();
		ArrayList<Dto_member> members = new ArrayList<>();
		try {
			// SQL 쿼리 실행하여 회원 목록 조회
			String sql = String.format("select * from %s", Db.TABLE_MEMBER);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				members.add(new Dto_member(rs.getString("B_ID"), rs.getString("B_PW"), rs.getString("B_nickname")));
			}

			// 자원 정리
			super.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}

	// (생략) 글 수, 페이지 수 관련 메서드도 구현되어 있음
	// 중복되는 주석은 생략하고, 새로운 메서드에 대한 주석을 추가해야 함

	/* 총 글 수 구하기 */
	public int getPostCount() {
		int count = 0;
		super.connect(); //[고정1,2,3]
		try {
				
			String sql = String.format(
					"select count(*) from %s"
					,Db.TABLE_PS_BOARD_FREE);
			System.out.println("sql : " + sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}
	/* 총 글 수 구하기 */
	public int getSearchPostCount(String word) {
		int count = 0;
		super.connect();	//[고정1,2,3]
		try {
			String sql = String.format(
					"select count(*) from %s where b_title like '%%%s%%'"
					,Db.TABLE_PS_BOARD_FREE, word);
			System.out.println("sql : "+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}	
	/* 글 리스트<검색> */
	public ArrayList<Dto> listSearch(String word,String page) {
		super.connect();	//[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<>();
		try {

			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT;
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_title like '%1%';
			String sql = String.format(
					"select * from %s where b_title like '%%%s%%' limit %s,%s"
					,Db.TABLE_PS_BOARD_FREE,word,startIndex,Board.LIST_AMOUNT);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NUM"),
						rs.getString("B_TITLE"),
						rs.getString("B_NICKNAME"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();
		return posts;
	}
	/* 총 페이지 수 구하기 */
	public int getTotalPageCount() {
		int totalPageCount = 0;
		int count = getPostCount();	//만든거 재활용.
		
		if(count % Board.LIST_AMOUNT == 0){		//case1. 나머지가 없이 딱 떨어지는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		}else{					//case2. 나머지가 있어서 짜투리 페이지가 필요한 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}	
	/* 총 페이지 수 구하기<검색> */
	public int getSearchTotalPageCount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostCount(word);
		
		if(count % Board.LIST_AMOUNT == 0){		//case1. 나머지가 없이 딱 떨어지는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		}else{					//case2. 나머지가 있어서 짜투리 페이지가 필요한 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
}
