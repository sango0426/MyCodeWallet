package com.sango.kiosk_v9;

import java.util.ArrayList;

public class ProcMenuDessert {
	public static int sum = 0;
	public void run() {
		yy:
		while(true) {
			//메뉴 출력
			System.out.println("=========================");
			System.out.println("======== 디저트 메뉴 =======");
			System.out.println("=========================");
			Kiosk.dessertMenu1.info();
			Kiosk.dessertMenu2.info();
			Kiosk.dessertMenu3.info();
			System.out.println("명령 선택 : [1.마카롱/2.치즈케이크/3.약과샌드/x.이전 화면]");
			Kiosk.cmd = Kiosk.sc.next();
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("마카롱 선택됨.");
				if(!Kiosk.basket.contains(Kiosk.dessertMenu1)) {
					System.out.println("마카롱이 장바구니에 담겼습니다.");
					Kiosk.basket.add(Kiosk.dessertMenu1);
					Kiosk.dessertMenu1.quantity++;
				} else {
					System.out.println("장바구니에 이미 같은 메뉴가 담겨있습니다. 수량을 증가시킵니다.");
					Kiosk.dessertMenu1.quantity++;
				}
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "2":
				System.out.println("치즈케이크 선택됨.");
				if(!Kiosk.basket.contains(Kiosk.dessertMenu2)) {
					System.out.println("치즈케이크가 장바구니에 담겼습니다.");
					Kiosk.basket.add(Kiosk.dessertMenu2);
					Kiosk.dessertMenu2.quantity++;
				} else {
					System.out.println("장바구니에 이미 같은 메뉴가 담겨있습니다. 수량을 증가시킵니다.");
					Kiosk.dessertMenu2.quantity++;
				}
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "3":
				System.out.println("약과샌드 선택됨.");
				if(!Kiosk.basket.contains(Kiosk.dessertMenu3)) {
					System.out.println("약과샌드가 장바구니에 담겼습니다.");
					Kiosk.basket.add(Kiosk.dessertMenu3);
					Kiosk.dessertMenu3.quantity++;
				} else {
					System.out.println("장바구니에 이미 같은 메뉴가 담겨있습니다. 수량을 증가시킵니다.");
					Kiosk.dessertMenu3.quantity++;
				}
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "x":
				System.out.println("이전화면으로 돌아갑니다");
				break yy;
			}
		}
		
	}
}
