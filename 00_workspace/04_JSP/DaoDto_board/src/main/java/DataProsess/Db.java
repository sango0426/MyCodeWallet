package DataProsess;
public class Db {
	static public String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";	//mysql
	static private String DB_NAME = "DaoDto";
	static private String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/" + DB_NAME;	//mysql
	static public String DB_URL = DB_URL_MYSQL;	//디비 바뀌면 여기 바꾸시오.
	static public String DB_ID = "root";
	static public String DB_PW = "root";
	
	/* table들 */
	////	게시판
	public static final String TABLE_PS_BOARD_FREE = "PS_BOARD_FREE";	//자유게시판
	
	////	FantasyTrip
//	public static final String TABLE_PLAYER = "FT_INS_PLAYER";
//	public static final String TABLE_CITY = "FT_INS_CITY";
//	public static final String TABLE_GOODS = "FT_GOODS";
//	public static final String TABLE_SHIP_CARGO = "FT_INS_SHIP_CARGO";
	
	////	회원
	public static final String TABLE_MEMBER = "member";	//peisia.com 회원 테이블명
	
	

}