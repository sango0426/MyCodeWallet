package CashCheck;

import Product.MainFunction;
import Product.Product;
import Util.Cw;

public class MenuCheck {
	public static void DrinkCheckRun() {
		int check_HotAmericano = 0;
		int check_IceAmericano = 0;
		int check_OrangeJuice = 0;
		if(!MainFunction.drink_B.isEmpty()) {
			for(int i = 0; i < MainFunction.drink_B.size(); i++) {
				Product drink_order = MainFunction.drink_B.get(i);
				if(drink_order.name.equals("뜨거운 아메리카노")) {
					check_HotAmericano++;
				}
				if(drink_order.name.equals("아이스 아메리카노")) {
					check_IceAmericano++;
				}
				if(drink_order.name.equals("오렌지 쥬스")) {
					check_OrangeJuice++;
				}
			}
			Cw.wn("================================");
			Cw.wn("[1.뜨거운 아메리카노 : " + check_HotAmericano + "]");
			Cw.wn("[2.아이스 아메리카노 : " + check_IceAmericano + "]");
			Cw.wn("[3.오렌지 쥬스 : " + check_OrangeJuice + "]");
			Cw.wn("================================");
		} else {
			Cw.wn("음료수 장바구니에 어떠한 상품도 담겨있지 않습니다.");
		}
	}
	
	public static void DessertCheckRun() {
		int check_Macarong = 0;
		int check_Cheese = 0;
		int check_sand = 0;
		if(!MainFunction.dessert_B.isEmpty()) {
			for(int i = 0; i < MainFunction.dessert_B.size(); i++) {
				Product dessert_order = MainFunction.dessert_B.get(i);
				if(dessert_order.name.equals("마카롱")) {
					check_Macarong++;
				}
				if(dessert_order.name.equals("치즈 케이크")) {
					check_Cheese++;
				}
				if(dessert_order.name.equals("약과 샌드")) {
					check_sand++;
				}
			}
			Cw.wn("================================");
			Cw.wn("[1.마카롱 : " + check_Macarong + "]");
			Cw.wn("[2.치즈 케이크 : " + check_Cheese + "]");
			Cw.wn("[3.약과 샌드 : " + check_sand + "]");
			Cw.wn("================================");
		} else {
			Cw.wn("디저트 장바구니에 어떠한 상품도 담겨있지 않습니다.");
		}
	}
}
