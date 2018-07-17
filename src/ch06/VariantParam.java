package ch06;

public class VariantParam {
	// 자료형 ... 변수 => 가변사이즈 매개변수
	// 같은 자료형의 매개변수의 갯수에 관계없이 처리
	// 매개변수들이 배열로 저장됨
	static void print(String ... n){
		for(int i=0; i<n.length; i++){
			System.out.println(n[i]);
		}
	}
//	static void print(String a){
//		System.out.println(a);
//	}
//	static void print(String a, String b){
//		System.out.println(a);
//		System.out.println(b);
//	}
//	static void print(String a, String b,String c){
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//	}
	
	public static void main(String[] args) {
		print("java");
		print("java","program");
		print("java","program","jsp");
	}
}
