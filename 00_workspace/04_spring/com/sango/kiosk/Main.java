package com.sango.kiosk;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("============================================");
		System.out.println("================= 고양이카페 ==================");
		System.out.println("============================================");
		//ctrl + shift + o(영문자). 자동 임포트.
		Scanner sc = new Scanner(System.in);
		String cmd;
		loop_a:
		while(true) {
			System.out.println("메뉴를 선택하세요[1.아메리카노/2.라떼/x.종료] : ");
			cmd = sc.next();
			loop_aa:
			switch(cmd) {
			case "1":
				loop_b:
				while(true) {
					System.out.println("세부메뉴를 선택하세요[1.HOT/2.(ICE)/x.이전 화면] : ");
					cmd = sc.next();
					switch(cmd) {
					case "1":
						System.out.println("아메리카노(HOT)을 주문하셨습니다. 감사합니다.");
						break;
					case "2":
						System.out.println("아메리카노(ICE)을 주문하셨습니다. 감사합니다.");
						break;
					case "x":
						break loop_aa;
					}
				}
			case "2":
				loop_c:
				while(true) {
					System.out.println("세부메뉴를 선택하세요[1.카페라떼/2.바닐라라떼/x.이전 화면] : ");
					cmd = sc.next();
					loop_cc:
					switch(cmd) {
					case "1":
						loop_d:
						while(true) {
							System.out.println("세부메뉴를 선택하세요[1.HOT/2.ICE/x.이전 화면] : ");
							cmd = sc.next();
							loop_dd:
							switch(cmd) {
							case "1":
								System.out.println("카페라떼(HOT)을 주문하셨습니다. 감사합니다.");
								break;
							case "2":
								System.out.println("카페라떼(ICE)을 주문하셨습니다. 감사합니다.");
								break;
							case "x":
								break loop_cc;
							}
						}
					case "2":
						loop_e:
						while(true) {
							System.out.println("세부메뉴를 선택하세요[1.HOT/2.ICE/x.이전 화면] : ");
							cmd = sc.next();
							loop_ee:
							switch(cmd) {
							case "1":
								System.out.println("바닐라라떼(HOT)을 주문하셨습니다. 감사합니다.");
								break;
							case "2":
								System.out.println("바닐라라떼(ICE)을 주문하셨습니다. 감사합니다.");
								break;
							case "x":
								break loop_cc;
							}
						}
					case "x":
						break loop_aa;
					}
				}
			case "x":
				break loop_a;
			}
		}
	}
}

