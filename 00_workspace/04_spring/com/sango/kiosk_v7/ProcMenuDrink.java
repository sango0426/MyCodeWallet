package com.sango.kiosk_v7;
//import com.sango.util.Cw;

public class ProcMenuDrink {
	public void run() {
		yy:
		while(true) {
			//메뉴 출력
			System.out.println("=========================");
			System.out.println("========== 메뉴 ==========");
			System.out.println("=========================");
			Kiosk.menu1.info();
			Kiosk.menu2.info();
			Kiosk.menu3.info();
			System.out.println("명령 선택 : [1.뜨아/2.아아/3.오렌지쥬스/x.이전 화면]");
			Kiosk.cmd = Kiosk.sc.next();
			switch(Kiosk.cmd) {
			case "1":
				System.out.println("뜨아 선택됨.");
				System.out.println("뜨거운 아메리카노가 장바구니에 담겼습니다.");
				Kiosk.basket.add(Kiosk.menu2);
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "2":
				System.out.println("아아 선택됨.");
				System.out.println("아이스아메리카노가 장바구니에 담겼습니다.");
				Kiosk.basket.add(Kiosk.menu2);
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "3":
				System.out.println("오렌지쥬스 선택됨.");
				System.out.println("오렌지쥬스가 장바구니에 담겼습니다.");
				Kiosk.basket.add(Kiosk.menu3);
				System.out.println("메뉴화면으로 돌아갑니다");
				break;
			case "x":
				System.out.println("이전화면으로 돌아갑니다");
				break yy;
			}
		}
	}
}