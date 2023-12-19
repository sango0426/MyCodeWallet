package com.sango.kiosk_v3;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("============================================");
		System.out.println("================= 고양이카페 ==================");
		System.out.println("============================================");
		
		Product menu1 = new Product("아메리카노(HOT)", 1000);
		Product menu2 = new Product("아메리카노(ICE)", 1500);
		Product menu3 = new Product("마카롱", 3000);
		
		Scanner sc = new Scanner(System.in);
		String cmd;
		loop_a:
		while(true) {
			System.out.println("============================================");
			System.out.println("================= 카페 메뉴 ==================");
			System.out.println("============================================");
			menu1.info();
			menu2.info();
			menu3.info();
			System.out.println("1.음료/2.디저트/x.종료 : ");
			cmd = sc.next();
			loop_aa:
			switch(cmd) {
			case "1":
				System.out.println("1." + menu1.name + "/2." + menu2.name + "/x.이전 화면");
				cmd = sc.next();
				loop_aaa:
				switch(cmd) {
				case "1":
					System.out.println(menu1.name + " 을 주문하셨습니다. 처음화면으로 돌아갑니다.");
					break loop_aa;
				case "2":
					System.out.println(menu2.name + " 을 주문하셨습니다. 처음화면으로 돌아갑니다.");
					break loop_aa;
				case "x":
					break loop_aa;
				}
			case "2":
				System.out.println(menu3.name + " 을 주문하셨습니다. 처음화면으로 돌아갑니다.");
				break loop_aa;
			case "x":
				System.out.println("키오스크를 종료합니다.");
				break loop_a;
			}
		}
	}
}
