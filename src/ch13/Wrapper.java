package ch13;
// Wrapper class(래퍼 클래스):기본 자료형을 포장하는 클래스
// 기본 자료형에 대한 다양한 method를 지원
public class Wrapper {
	public static void main(String[] args) {
		Integer i1 = new Integer(10);
		//auto boxing(value를 객체로 포장하는 작업)
		Integer i2 = new Integer(20);
		int num1 = i1.intValue();
		//auto unboxing(객체로 포장된 value를 꺼내는 작업)
		int num2 = i2;
		int sum = num1 + num2;
		System.out.println(sum);
		
		//2진수 문자열로
		System.out.println(Integer.toBinaryString(sum));
		//8진수 문자열로
		System.out.println(Integer.toOctalString(sum));
		//16진수 문자열로
		System.out.println(Integer.toHexString(sum));
		System.out.println(Integer.MAX_VALUE); //정수의 최대값
		System.out.println(Integer.MIN_VALUE); //정수의 최소값
		//문자열을 정수로
		System.out.println(Integer.parseInt("100"));
		//정수를 문자열로
		System.out.println(Integer.toString(100));
		System.out.println(100+"");
		
	}
}
