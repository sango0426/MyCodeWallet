package com.sango.kiosk_v8;
import java.util.ArrayList;
import java.util.Scanner;
import com.sango.kiosk_v8.Cw;

public class Kiosk {
	public static ProcMenuDrink procMenuDrink = new ProcMenuDrink();
	public static ArrayList<Product> basket = new ArrayList<Product>();

	public static Scanner sc = new Scanner(System.in);
	public static Product menu1 = new Product("뜨아", 1000, 0);
	public static Product menu2 = new Product("아아", 1500, 0);
	public static Product menu3 = new Product("오렌지쥬스", 2000, 0);
	public static String cmd;
	
	void run() {
		Display.title();
		xx:
			while(true) {
				System.out.println("명령 선택 : [1.음료 선택/2.디저트 선택/3.장바구니 보기/e.프로그램 종료]");
				cmd = sc.next();
				zz:
				switch(cmd) {
				case "1":
					procMenuDrink.run();
					break;
				case "2":
					System.out.println("디저트선택 개발중. 다음 버전을 기대해주세요!");
					System.out.println("메뉴화면으로 돌아갑니다.");
					break zz;
				case "3":
					System.out.println("현재 나의 장바구니");
					System.out.println("현재 나의 장바구니에 " + basket.size() + "개의 상품이 담겨있습니다.");
					System.out.println("1.장바구니에 담겨있는 상품들 보기/x. 이전 메뉴로 돌아가기");
					cmd = sc.next();
					switch(cmd) {
					case "1":
						Summation.sum_v1();
						System.out.println("x.처음으로 돌아가기");
						cmd = sc.next();
						switch(cmd) {
							case "x":
								break zz;
						}
						break zz;
					}
					case "x":
						break zz;
				case "e":
					System.out.println("프로그램을 종료합니다.");
					break xx;
			}
		}
	}
}
