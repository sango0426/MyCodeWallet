package Main;

import Product.DessertData;
import Product.MainFunction;
import Product.Product;
import Util.Cw;

public class Dessert {
	//드링크 메뉴 화면 출력
	public static void DessertInfo() {
		System.out.println("--------------------");
		System.out.println("----- 디저트 메뉴 -----");
		System.out.println("--------------------");
		for(Product p : MainFunction.dessert) {
			if(p instanceof DessertData) {
				Cw.wn("상품명 : " + p.name + "/가격 : " + p.price);
			}
		}
		Cw.wn("====================");
		dessertstart:
			while(true) {
				Cw.wn("1.마카롱/2.치즈 케이크/3.약과 샌드/x.이전 화면");
				MainFunction.cmd = MainFunction.sc.next();
				switch(MainFunction.cmd) {
				case "1":
					Cw.wn("====================");
					Cw.wn("마카롱을 선택했습니다. 마카롱이 장바구니에 추가됩니다.");
					Cw.wn("메뉴 선택 화면으로 돌아갑니다.");
					Cw.wn("====================");
					MainFunction.dessert_B.add(MainFunction.dessert.get(0));
					break dessertstart;
				case "2":
					Cw.wn("====================");
					Cw.wn("치즈 케이크를 선택했습니다. 치즈 케이크가 장바구니에 추가됩니다.");
					Cw.wn("메뉴 선택 화면으로 돌아갑니다.");
					Cw.wn("====================");
					MainFunction.dessert_B.add(MainFunction.dessert.get(1));
					break dessertstart;
				case "3":
					Cw.wn("====================");
					Cw.wn("약과 샌드를 선택했습니다. 약과 샌드가 장바구니에 추가됩니다.");
					Cw.wn("메뉴 선택 화면으로 돌아갑니다.");
					Cw.wn("====================");
					MainFunction.dessert_B.add(MainFunction.dessert.get(2));
					break dessertstart;
				case "x":
					break dessertstart;
				}
		
			}
	
	}
}
