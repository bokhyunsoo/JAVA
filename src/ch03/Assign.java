package ch03;

public class Assign {
	public static void main(String[] args) {
		int a=3, b=5;
		a += 3; // a=a+3;
		System.out.println(a);
		b /=5; // b=b/5;
		System.out.println(b);
		a = 12;
		a >>= 2; // a=a>>2; 우측으로 2비트 쉬프트
		System.out.println(a);
	}
}
