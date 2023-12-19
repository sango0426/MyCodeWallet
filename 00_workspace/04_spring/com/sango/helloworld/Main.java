package com.sango.helloworld;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("가위바위보 중에 하나 입력해주세요:");

		Scanner sc = new Scanner(System.in);
		//new : 객체를 생성해라.

		String userRpc = sc.next();

		System.out.println("님이 낸것은:" + userRpc);

		int r = (int) (Math.random() * 3 + 1); // 1~6 까지 랜덤하게 뽑음
		System.out.println("주사위를 굴려 " + r + "이 나왔습니다.");

		String comRpc = "";
		if (r == 1) {
			comRpc = "가위";
		} else if (r == 2) {
			comRpc = "바위";
		} else if (r == 3) {
			comRpc = "보";
		}

		System.out.println("컴퓨터가 " + comRpc + " 냈습니다.");

		// todo
		// 결과 판정
		String result = "";
		

		if (userRpc.equals("가위")) {
			//"문자열"은 .equals함수로 비교
			if (comRpc.equals("가위")) {
				result = "비김";
			}
			if (comRpc.equals("바위")) {
				result = "짐";
			}
			if (comRpc.equals("보")) {
				result = "이김";
			}
		}
		if (userRpc.equals("바위")) {
			if (comRpc.equals("가위")) {
				result = "이김";
			}
			if (comRpc.equals("바위")) {
				result = "비김";
			}
			if (comRpc.equals("보")) {
				result = "짐";
			}
		}
		if (userRpc.equals("보")) {
			if (comRpc.equals("가위")) {
				result = "짐";
			}
			if (comRpc.equals("바위")) {
				result = "이김";
			}
			if (comRpc.equals("보")) {
				result = "비김";
			}
		}
		System.out.println("결과:" + result);
	}
}
