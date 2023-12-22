package Main;

import CashCheck.Cash;
import CashCheck.MenuCheck;
import Product.MainFunction;
import Util.Cw;

public class Kiosk {
	void run() {
		MainFunction.DrinkLoad();
		MainFunction.DessertLoad();
		System.out.println("고양이 카페에 오신것을 환영합니다.");
		start:
			while(true) {
				System.out.println("메뉴를 선택해주세요.");
				System.out.println("[1.음료수/2.디저트/3.장바구니/4.계산하기/x.프로그램 종료]");
				MainFunction.cmd = MainFunction.sc.next();
				switch(MainFunction.cmd) {
				case "1":
					Drink.DrinkInfo();
					break;
				case "2":
					Dessert.DessertInfo();
					break;
				case "3":
					MenuCheck.DrinkCheckRun();
					MenuCheck.DessertCheckRun();
					break;
				case "4":
					Cash.CashSum();
					break;
				case "x":
					break start;
				}
			}
	}
}
