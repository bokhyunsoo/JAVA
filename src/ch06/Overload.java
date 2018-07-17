package ch06;

public class Overload {
	public static void main(String[] args) {
		print(10);
		print(100.5);
		print("java");
	}

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
