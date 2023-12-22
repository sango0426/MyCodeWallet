package CashCheck;

import Product.MainFunction;
import Product.Product;
import CashCheck.MenuCheck;
import Main.Dessert;
import Main.Drink;
import Util.Cw;

public class Cash {
	public static void CashSum() {
		int sum = 0;
		int hotsum = 0;
		int icesum = 0;
		int juicesum = 0;
		int macasum = 0;
		int cakesum = 0;
		int sandsum = 0;
		
		if(!MainFunction.drink_B.isEmpty() || !MainFunction.dessert_B.isEmpty()) {
			Cw.wn("====================");
			Cw.wn("현재 장바구니 목록입니다.");
			Cw.wn("====================");
			for(int i = 0; i < MainFunction.drink_B.size(); i++) {
				Product Drink_Order = MainFunction.drink_B.get(i);
				if(Drink_Order.name.equals("뜨거운 아메리카노")) {
					hotsum = hotsum + Drink_Order.price;
				}
				if(Drink_Order.name.equals("아이스 아메리카노")) {
					icesum = icesum + Drink_Order.price;
				}
				if(Drink_Order.name.equals("오렌지 쥬스")) {
					juicesum = juicesum + Drink_Order.price;
				}
			}
			for(int i = 0; i < MainFunction.dessert_B.size(); i++) {
				Product Dessert_Order = MainFunction.dessert_B.get(i);
				if(Dessert_Order.name.equals("마카롱")) {
					macasum = macasum + Dessert_Order.price;
				}
				if(Dessert_Order.name.equals("치즈 케이크")) {
					cakesum = cakesum + Dessert_Order.price;
				}
				if(Dessert_Order.name.equals("약과 샌드")) {
					sandsum = sandsum + Dessert_Order.price;
				}
			}
			if(hotsum != 0) {
				Cw.wn("뜨거운 아메리카노/총 " + hotsum + "원");
			}
			if(icesum != 0) {
				Cw.wn("아이스 아메리카노/총 " + icesum + "원");
			}
			if(juicesum != 0) {
				Cw.wn("오렌지 쥬스/총 " + juicesum + "원");
			}
			if(macasum != 0) {
				Cw.wn("마카롱/총 " + macasum + "원");
			}
			if(cakesum != 0) {
				Cw.wn("치즈 케이크/총 " + cakesum + "원");
			}
			if(sandsum != 0) {
				Cw.wn("약과 샌드/총 " + sandsum + "원");
			}
			sum = hotsum + icesum + juicesum + macasum + cakesum + sandsum;
			Cw.wn("계산하실 금액은 총 " + sum +"원입니다.");
			Cw.wn("====================");
			Cw.wn("메인 화면으로 돌아갑니다.");
			Cw.wn("====================");
			MainFunction.drink_B.clear();
			MainFunction.dessert_B.clear();
			
		} else {
			Cw.wn("장바구니에 어떠한 상품도 담겨있지 않습니다.");
		}
	}
}
