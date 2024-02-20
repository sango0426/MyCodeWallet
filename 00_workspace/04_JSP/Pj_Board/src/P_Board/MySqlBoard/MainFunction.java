package P_Board.MySqlBoard;

import java.util.ArrayList;
import java.util.Scanner;

import P_Board.Data.BodyData;
import P_Board.Data.IdData;
import P_Board.Data.PwData;
import P_Board.Data.TitleData;
import P_Board.Data.UserIdData;

public class MainFunction {
	// 배열 추가
	public static ArrayList<IdData> id = new ArrayList<IdData>();
	public static ArrayList<PwData> pw = new ArrayList<PwData>();
	public static ArrayList<BodyData> textbody = new ArrayList<BodyData>();
	public static ArrayList<TitleData> texttitle = new ArrayList<TitleData>();
	public static ArrayList<UserIdData> memberid = new ArrayList<UserIdData>();
	
	//id배열 출력(디버깅이나 배열상태 확인)
	public static void printIdArray() {
        System.out.println("Id Array");
        for (IdData idData : id) {
            System.out.println(idData.getId());
        }
        System.out.println("-------------------------");
    }
	
	// 기본 펑션들
	public static String cmd;
	public static Scanner sc = new Scanner(System.in);
}
