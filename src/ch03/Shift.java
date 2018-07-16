package ch03;

public class Shift {
	public static void main(String[] args) {
		int a = 2;
		int b = a << 2; // a의 값을 좌측으로 2비트 쉬프트(곱셈)
		// 빈 자리는 0으로 채워짐
		System.out.println(b);
		b = b >> 2; // b의 값을 우측으로 2비트 쉬프트(나눗셈)
		System.out.println(b);
	}
}
