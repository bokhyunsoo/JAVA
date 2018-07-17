package ch06;

public class Abs {
	static int abs(int num){
		//조건식 ? true일 때의 값 : false일 때의 값
		return num>0 ? num : -num;
	}
	
	public static void main(String[] args) {
		int a=-5;
		System.out.println(a);
		System.out.println(abs(a));
		System.out.println(Math.abs(a));
	}
}
