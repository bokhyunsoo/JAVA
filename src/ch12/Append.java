package ch12;

public class Append {
	public static void main(String[] args) {
		String a="hello"; // 불변 immutable
		a = a+"java";
		System.out.println(a);
		//가변 mutable
		StringBuilder b = new StringBuilder("hello");
		b.append("java");
		System.out.println(b);
	}
}
