package ch03;

public class Compare {
	public static void main(String[] args) {
		int a = 65;
		char c = 'A';
// 자료형이 다르면 작은 자료형이 큰 자료형으로 임시형변환
		System.out.println(a == c); // 비교
		System.out.println(a = c); //대입
		System.out.println('A' != 65);
	}
}
