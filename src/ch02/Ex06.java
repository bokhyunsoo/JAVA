package ch02;

public class Ex06 {
	public static void main(String[] args) {
		//정수형 변수 num1에 10을 대입
		int num1=10; //4byte ... 0000.....1010
		System.out.println(num1);
		//int 최대값
		System.out.println(Integer.MAX_VALUE);
		//int 최소값
		System.out.println(Integer.MIN_VALUE);
		//int의 사이즈(비트수)
		System.out.println(Integer.SIZE);
		//long : 8바이트
		//숫자+L(l) => 8바이트로 저장됨
		long num2=21474836470L;
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.SIZE); //64bit(8바이트)
		
		byte num3=127;
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.SIZE);
		
		//Wrapper class(래퍼 클래스)
//		기본자료형		참조자료형
//		int				Integer
//		char			Character
//		boolean			Boolean
//		double			Double
	}
}
