package ch10;

public class StaticMethod {
	static int a = 10;
	int b = 20;
	//static method에서는 nonstatic member를
	//참조할 수 없음
	public static void printA(){
		System.out.println(a);
		//System.out.println(b);
//		StaticMethod s = new StaticMethod();
//		System.out.println(s.b);
	}
	public void printB(){
		System.out.println(a);
		System.out.println(b);
	}
}
