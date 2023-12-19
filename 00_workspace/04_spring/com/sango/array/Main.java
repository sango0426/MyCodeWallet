package com.sango.array;

public class Main {
	public static void main(String[] args) {
		// java 배열은 js랑 달리 자리수를 처음에 정해주면 더이상 늘리거나 줄일 수 없음

		// 배열 선언 법 - 1. 자리수만 잡아주는 선언
		int n[] = new int[2]; // 0 으로 초기화 됨.
		// int []n = new int[2]; // 0 으로 초기화 됨. []의 위치는 방식 두가지임. 개인 취향.
		System.out.println(n[1]); // 출력 : 0

		n[0] = 1;
		n[1] = 2;
		System.out.print(n[0]); // 출력 후 엔터 안하는 애(오른쪽으로 쭉 찍힘)/출력 : 1(엔터안함)
		System.out.println(n[1]); // 출력 후 엔터하는 애/출력 : 2(엔터)

		String s[] = new String[2]; // null 로 초기화 됨.
		System.out.println(s[1]); // 출력 : null
		s[0] = "개";
		s[1] = "괭이";
		System.out.print(s[0]); // 출력 : 개(엔터안함)
		System.out.println(s[1]); // 출력 : 괭이(엔터)

		// 배열 선언 법 - 2.바로 값도 주는 선언(방식1)
		int m[] = new int[] {1, 2};

		System.out.print(m[0]); // 출력 : 1(엔터안함)
		System.out.println(m[1]); // 출력 : 2(엔터)

		// 배열 선언 법 - 3.바로 값도 주는 선언(방식2)
		int x[] = {1, 2};

		System.out.print(x[0]); // 출력 : 1(엔터안함)
		System.out.print(x[1]); // 출력 : 2(엔터안함)
	}
}
