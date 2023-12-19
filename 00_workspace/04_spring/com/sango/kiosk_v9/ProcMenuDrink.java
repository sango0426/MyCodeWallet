package com.sango.kiosk_v9;

public class ProcMenuDrink {
	public static int sum = 0;
	public void run() {
		yy:
		while(true) {
			//메뉴 출력
			System.out.println("=========================");
			System.out.println("========== 메뉴 ==========");
			System.out.println("=========================");
			Kiosk.drinkMenu1.info();
			Kiosk.drinkMenu2.info();
			Kiosk.drinkMenu3.info();
			System.out.println("명령 선택 : [1.뜨아/2.아아/3.오렌지쥬스/x.이전 화면]");
			Kiosk.cmd = Kiosk.sc.next();
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("뜨아 선택됨.");
				if(!Kiosk.basket.contains(Kiosk.drinkMenu1)) {
					System.out.println("뜨거운 아메리카노가 장바구니에 담겼습니다.");
					Kiosk.basket.add(Kiosk.drinkMenu1);
					Kiosk.drinkMenu1.quantity++;
				} else {
					System.out.println("장바구니에 이미 같은 메뉴가 담겨있습니다. 수량을 증가시킵니다.");
					Kiosk.drinkMenu1.quantity++;
				}
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "2":
				System.out.println("아아 선택됨.");
				if(!Kiosk.basket.contains(Kiosk.drinkMenu2)) {
					System.out.println("아이스 아메리카노가 장바구니에 담겼습니다.");
					Kiosk.basket.add(Kiosk.drinkMenu2);
					Kiosk.drinkMenu2.quantity++;
				} else {
					System.out.println("장바구니에 이미 같은 메뉴가 담겨있습니다. 수량을 증가시킵니다.");
					Kiosk.drinkMenu2.quantity++;
				}
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "3":
				System.out.println("오렌지쥬스 선택됨.");
				if(!Kiosk.basket.contains(Kiosk.drinkMenu3)) {
					System.out.println("오렌즈쥬스가 장바구니에 담겼습니다.");
					Kiosk.basket.add(Kiosk.drinkMenu3);
					Kiosk.drinkMenu3.quantity++;
				} else {
					System.out.println("장바구니에 이미 같은 메뉴가 담겨있습니다. 수량을 증가시킵니다.");
					Kiosk.drinkMenu3.quantity++;
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