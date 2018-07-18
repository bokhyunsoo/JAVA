package ch13;

public class WrapDouble {
	public static void main(String[] args) {
		//Double num1 = new Double("11.5"); //래퍼클래스
		Double num1 = 11.5; //auto boxing
		double num2 = 3.5; //기본자료형
		double num3 = num1/num2; //auto unboxing
		System.out.println(num3);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		String str = "11.5";
		//산술연산이 아닌 문자열로 처리됨
		//Integer.toString(200) => "200"
		System.out.println(str+200); // "11.5" + "200"
		System.out.println(Double.parseDouble(str)+200);
	}
}
