package com.sango.kiosk_v8;

public class Product {
	//변수들
	String name;
	int price;
	int quantity;
	
	Product(String xx, int yy, int zz) {
		name = xx;
		price = yy;
		quantity = zz;
	}
	
	public void info() {
		System.out.println("메뉴이름 : " + name + ", 가격 : " + price + "원");
	}
}