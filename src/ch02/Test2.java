package ch02;

public class Test2 {
	
	static int n; //전역변수(초기화 생략가능)
	static void test() {
		int a; //지역변수
		//System.out.println(b);
		System.out.println("n="+n);
	}
	
	public static void main(String[] args) {
		int b=0; //지역변수는 반드시 초기화해야 함
		System.out.println(n);
		System.out.println(b);
		test();
	}
}