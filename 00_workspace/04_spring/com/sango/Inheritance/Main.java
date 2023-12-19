package com.sango.Inheritance;

public class Main {
	public static void main(String[] args) {
		Character elf = new Character();
		elf.name = "엠피스";
		elf.hp = 1;
		elf.info();
		
		Item book = new Item();
		book.weight = 100;
		book.name = "1클래스 마법서";
		book.info();
		
		Sword shortSword = new Sword();
		shortSword.name = "단검";
		shortSword.attack = 100;
		shortSword.weight = 10;
		shortSword.info();
		
	}
}
