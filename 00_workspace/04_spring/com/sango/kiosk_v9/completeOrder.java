package com.sango.kiosk_v9;

public class completeOrder {
	public static void complete() {
		int sum = 0;
		for(Product x : Kiosk.basket) {
			System.out.println("============================");
			System.out.println("====현재 장바구니에 담긴 상품====");
			System.out.println("============================");
			System.out.println("상품명 : " + x.name + "/수량 : " + x.quantity + "개");
			sum = sum + (x.price * x.quantity);
			x.quantity = 0;
			System.out.println("총 가격 : " + sum + "원");
			System.out.println("결제 완료.");
		}
	}
}
