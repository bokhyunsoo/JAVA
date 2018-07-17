package ch06;

public class Call {
	static void test(int b){
		System.out.println("test method 호출");
		System.out.println(b);
	}
	
	static void test2(int[] n){
		for(int i=0; i<n.length; i++){
			System.out.println(n[i]+"\t");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("시작");
		int a=10;
		test(a);
		int[] num = {10,20,30,40,50};
		test2(num);
		System.out.println("끝");
	}
}
