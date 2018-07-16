package ch03;

public class Cast {
	public static void main(String[] args) {
		float f = 1.6f; // 실수+f => 4byte로 저장
		f = 100; // 실수형 변수에 정수값 대입(자동형변환)
		System.out.println(f);
		f = 100.5f;
		int i = (int)f; // 강제형변환, 명시적형변환
		System.out.println(i); // 소수 이하가 손실됨
		i = 300;
		byte b = (byte)i; //error
		System.out.println(b); // overflow 발생
	}
}
