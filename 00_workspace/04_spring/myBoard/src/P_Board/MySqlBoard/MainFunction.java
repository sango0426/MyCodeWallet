package P_Board.MySqlBoard;

import java.util.ArrayList;
import java.util.Scanner;

import P_Board.Data.BodyData;
import P_Board.Data.IdData;
import P_Board.Data.PwData;
import P_Board.Data.ReplyData;
import P_Board.Data.TitleData;
import P_Board.Data.UserIdData;

/*
 * MainFunction 클래스
 * - 사용자의 입력을 저장하고, 여러 데이터를 관리하는 기능들을 제공하는 클래스입니다.
 */

public class MainFunction {
	// 다양한 데이터를 저장하는 배열들
	public static ArrayList<IdData> id = new ArrayList<IdData>();
	public static ArrayList<PwData> pw = new ArrayList<PwData>();
	public static ArrayList<BodyData> textbody = new ArrayList<BodyData>();
	public static ArrayList<TitleData> texttitle = new ArrayList<TitleData>();
	public static ArrayList<ReplyData> textreply = new ArrayList<ReplyData>();

	/**
	 * id 배열 출력 메서드 - 디버깅이나 배열 상태 확인에 사용됩니다.
	 */
	public static void printIdArray() {
		System.out.println("Id Array");
		for (IdData idData : id) {
			System.out.println(idData.getId());
		}
		System.out.println("-------------------------");
	}

	// 기본 함수들
	public static String cmd; // 사용자 입력을 저장하는 변수
	public static Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
}
