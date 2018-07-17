package ch06;

public class Overload {
	public static void main(String[] args) {
		//Object obj = 10;
//		Object obj = new Integer(10);
//		obj=100.5;
//		obj = new Double(100.5);
//		obj = new String("java");
		print(10);
		print(100.5);
		print("java");
		Overload o = new Overload();
	}

//	static void print(Object obj){
//		System.out.println(obj);
//	}
	
	private static void print(String str) {
		System.out.println(str);
	}

	private static void print(double d) {
		System.out.println(d);
	}

	static void print(int i) {
		System.out.println(i);
	}
}
