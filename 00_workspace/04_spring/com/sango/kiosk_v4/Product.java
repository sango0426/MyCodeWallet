package com.sango.kiosk_v4;

public class Product {
	//변수들
	String name;
	int price;
	
	Product(String xx, int yy) {
		name = xx;
		price = yy;
	}
	
	public void info() {
		System.out.println("메뉴이름 : " + name + ", 가격 : " + price + "원");
	}
}
