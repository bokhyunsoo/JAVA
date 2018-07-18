package ch13;

public class AutoBox {
	public static void main(String[] args) {
		//기본 자료형
		int num1 = 10;
		int num2;
		//클래스 자료형
		Integer i1; // 객체참조변수(주소값 저장)
		Integer i2 = new Integer(20);
		i1 = num1; // auto boxing
		num2 = i2; // auto unboxing
		System.out.println(num1+","+i1);
		System.out.println(num2+","+i2);
	}
}
