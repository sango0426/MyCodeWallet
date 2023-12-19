package com.sango.kiosk_v9;

public class Summation {
	
	public static void sum_v1() {
		int sum = 0;
		if(!Kiosk.basket.isEmpty()) {
			for(Product x : Kiosk.basket) {
				System.out.println("상품명 : " + x.name + "/수량 : " + x.quantity + "개");
				sum = sum + (x.price * x.quantity);
			}
			System.out.println("총 가격 : " + sum + "원");
		} else {
			System.out.println("장바구니가 비어있습니다.");
		}
	}
	
}
