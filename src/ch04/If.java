package ch04;

import java.util.Scanner;

public class If {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요:");
		int num = scan.nextInt();
		if(num % 2 == 0){ // num을 2로 나눈 나머지가 0이면
			System.out.println(num+"은 짝수입니다.");
		} else {
			System.out.println(num+"은 홀수입니다.");
		}
	}
}
