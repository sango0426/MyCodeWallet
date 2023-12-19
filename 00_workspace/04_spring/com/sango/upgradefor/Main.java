package com.sango.upgradefor;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<>();
		animals.add("고양이");
		animals.add("개");
		animals.add("토끼");
		
		for(int i=0;i<animals.size();i=i+1) {
			System.out.println(animals.get(i));
		}
		
		//향상된 for문(for-each라고도 함)
		for(String x:animals) {
			System.out.println(x);
		}
		
		int a[]= {1,2,3};
		for(int n:a) {
			System.out.println(n);
		}
		
		Cat cat1 = new Cat("키티",5);
		Cat cat2 = new Cat("괭이",4);
		ArrayList<Cat> cats = new ArrayList<>();
		cats.add(cat1);
		cats.add(cat2);
		for(Cat x:cats) {
			System.out.println("고양이이름:"+x.name);
			System.out.println("고양이나이:"+x.age);
		}
	}
}