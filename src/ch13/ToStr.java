package ch13;
//Object는 모든 자료형을 담을 수 있음
public class ToStr {
	public static void main(String[] args) {
		Object obj = new Object();
		//오토박싱(auto boxing)
		obj = new Integer(20);
		//obj = 20;
		System.out.println(obj); //오토언박싱(auto unboxing)
		obj = new Double(20.5);
		//obj = 20.5;
		System.out.println(obj);
		obj = new String("hello");
//		obj = "hello";
		System.out.println(obj);
	}
}
