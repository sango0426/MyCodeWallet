package com.sango.kiosk_v6;
import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
	ArrayList<Product> basket = new ArrayList<Product>();
	Scanner sc = new Scanner(System.in);
	Product menu1 = new Product("뜨아", 1000);
	Product menu2 = new Product("아아", 1500);
	Product menu3 = new Product("오렌지쥬스", 2000);
	String cmd;
	
	void run() {
		Display.title();
		xx:
			while(true) {
				System.out.println("명령 선택 : [1.음료 선택/2.디저트 선택/3.장바구니 보기/e.프로그램 종료]");
				cmd = sc.next();
				zz:
				switch(cmd) {
				case "1":
					while(true) {
						//메뉴 출력
						System.out.println("=========================");
						System.out.println("========== 메뉴 ==========");
						System.out.println("=========================");
						menu1.info();
						menu2.info();
						menu3.info();
						System.out.println("명령 선택 : [1.뜨아/2.아아/3.오렌지쥬스/x.이전 화면]");
						cmd = sc.next();
						switch(cmd) {
						case "1":
							System.out.println("뜨아 선택됨.");
							System.out.println("뜨거운 아메리카노가 장바구니에 담겼습니다.");
							basket.add(menu1);
							System.out.println("메뉴화면으로 돌아갑니다");
							break;
						case "2":
							System.out.println("아아 선택됨.");
							System.out.println("아이스아메리카노가 장바구니에 담겼습니다.");
							basket.add(menu2);
							System.out.println("메뉴화면으로 돌아갑니다");
							break;
						case "3":
							System.out.println("오렌지쥬스 선택됨.");
							System.out.println("오렌지쥬스가 장바구니에 담겼습니다.");
							basket.add(menu3);
							System.out.println("메뉴화면으로 돌아갑니다");
							break;
						case "x":
							System.out.println("이전화면으로 돌아갑니다");
							break zz;
						}
					}
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
						if(!basket.isEmpty()) {
							for(int i = 0; i < basket.size(); i++) {
								System.out.println("상품명 : " + basket.get(i).name + "/가격 : " + basket.get(i).price);
							}
						} else {
							System.out.println("장바구니가 비어있습니다.");
						}
						
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
