package ch03;

public class Increase {
	public static void main(String[] args) {
		int i = 5;
		int j = 0;
		j = i++; // 다른 연산을 먼저 하고 증가시킴
		System.out.println(i+","+j); // 6,5
		i = 5;
		j = ++i; // 먼저 증가시킴
		System.out.println(i+","+j); // 6,6
	}
}
