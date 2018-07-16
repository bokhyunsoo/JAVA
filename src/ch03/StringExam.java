package ch03;

public class StringExam {
	public static void main(String[] args) {
		// 문자열 + 문자열 => 문자열 연결 연산자
		String str = "Hello "+"java";
		System.out.println(str);
		// 숫자 123이 문자열로 임시로 바뀌어서 연결됨
		str = 123 + "c";
		System.out.println(str);
	}
}
