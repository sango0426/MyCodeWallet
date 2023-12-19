package com.sango.lotto;

public class Lotto {
	public void run() {
		int userNum[] = new int[6];
		userNum[0] = 1;
		userNum[1] = 2;
		userNum[2] = 3;
		userNum[3] = 4;
		userNum[4] = 5;
		userNum[5] = 6;
		int ranNum[] = new int[6];
		ranNum[0] = (int) (Math.random() * 45 + 1);

		// 첫번째와 두번째 번호 중복 검사
		while (true) {
			ranNum[1] = (int) (Math.random() * 45 + 1);
			if (ranNum[0] != ranNum[1]) {
				break;
			}
		}

		// 첫번째와 두번째 번호 중복 검사
		while (true) {
			ranNum[1] = (int) (Math.random() * 45 + 1);
			if (ranNum[1] != ranNum[0]) {
				break;
			}
		}

		// 번호 중복 검사(첫번째, 두번째, 세번째)
		while (true) {
			ranNum[2] = (int) (Math.random() * 45 + 1);
			if (ranNum[2] != ranNum[0] && ranNum[2] != ranNum[1]) {
				break;
			}
		}

		// 번호 중복 검사(첫번째, 두번째, 세번째, 네번째)
		while (true) {
			ranNum[3] = (int) (Math.random() * 45 + 1);
			if (ranNum[3] != ranNum[0] && ranNum[3] != ranNum[1] && ranNum[3] != ranNum[2]) {
				break;
			}
		}

		// 번호 중복 검사(첫번째, 두번째, 세번째, 네번째, 다섯번째)
		while (true) {
			ranNum[4] = (int) (Math.random() * 45 + 1);
			if (ranNum[4] != ranNum[0] && ranNum[4] != ranNum[1] && ranNum[4] != ranNum[2] && ranNum[4] != ranNum[3]) {
				break;
			}
		}

		// 번호 중복 검사(첫번째, 두번째, 세번째, 네번째, 다섯번째, 여섯번째)
		while (true) {
			ranNum[4] = (int) (Math.random() * 45 + 1);
			if (ranNum[5] != ranNum[0]
				&& ranNum[5] != ranNum[1]
				&& ranNum[5] != ranNum[2]
				&& ranNum[5] != ranNum[3]
				&& ranNum[5] != ranNum[4]) {
				break;
			}
		}

		System.out.println("==========당첨 번호==========");
		System.out.print(ranNum[0] + " ");
		System.out.print(ranNum[1] + " ");
		System.out.print(ranNum[2] + " ");
		System.out.print(ranNum[3] + " ");
		System.out.print(ranNum[4] + " ");
		System.out.println(ranNum[5]);

		int win = 0;

		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (userNum[i] == ranNum[j]) {
					win = win + 1;
				}
			}
		}

		System.out.println("맞춘 갯수 : " + win);

	}
}
