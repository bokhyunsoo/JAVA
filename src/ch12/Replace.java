package ch12;

public class Replace {
	public static void main(String[] args) {
		String a = "java program";
		System.out.println(a.replace("a", "A"));
		System.out.println(a);
		a = a.replace("a", "A");
		System.out.println(a);
	}
}
