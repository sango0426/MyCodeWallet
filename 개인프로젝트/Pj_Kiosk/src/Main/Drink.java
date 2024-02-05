package Main;

import Product.MainFunction;
import Product.Product;
import Product.DrinkData;
import Util.Cw;

public class Drink {
	//드링크 메뉴 화면 출력
	public static void DrinkInfo() {
		System.out.println("--------------------");
		System.out.println("----- 음료수 메뉴 -----");
		System.out.println("--------------------");
		for(Product p : MainFunction.drink) {
			if(p instanceof DrinkData) {
				Cw.wn("상품명 : " + p.name + "/가격 : " + p.price);
			}
		}
		Cw.wn("====================");
		drinkstart:
			while(true) {
				Cw.wn("1.뜨거운 아메리카노/2.아이스 아메리카노/3.오렌지 쥬스/x.이전 화면");
				MainFunction.cmd = MainFunction.sc.next();
				switch(MainFunction.cmd) {
				case "1":
					Cw.wn("====================");
					Cw.wn("뜨거운 아메리카노를 선택했습니다. 뜨거운 아메리카노가 장바구니에 추가됩니다.");
					Cw.wn("음료수 메뉴 선택 화면으로 돌아갑니다.");
					Cw.wn("====================");
					MainFunction.drink_B.add(MainFunction.drink.get(0));
					break drinkstart;
				case "2":
					Cw.wn("====================");
					Cw.wn("아이스 아메리카노를 선택했습니다. 아이스 아메리카노가 장바구니에 추가됩니다.");
					Cw.wn("음료수 메뉴 선택 화면으로 돌아갑니다.");
					Cw.wn("====================");
					MainFunction.drink_B.add(MainFunction.drink.get(1));
					break drinkstart;
				case "3":
					Cw.wn("====================");
					Cw.wn("오렌지 쥬스를 선택했습니다. 오렌지 쥬스가 장바구니에 추가됩니다.");
					Cw.wn("음료수 메뉴 선택 화면으로 돌아갑니다.");
					Cw.wn("====================");
					MainFunction.drink_B.add(MainFunction.drink.get(2));
					break drinkstart;
				case "x":
					break drinkstart;
			}
		}
		
	}
}
