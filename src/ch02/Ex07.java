package ch02;

public class Ex07 {
	public static void main(String[] args) {
		//float 4byte, double 8byte
		//실수형 변수 num1에 원주율 대입
		//Math : 수학계산을 지원하는 클래스
		double num1 = Math.PI;
		System.out.println(num1);
		//int a=10.5;
		double a = 10.5;
		a=10.;
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.SIZE);
		//float : 4byte
		//실수값+F(f) => 4byte float type로 저장됨
		float b = 10.5f;
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.SIZE);
	}
}