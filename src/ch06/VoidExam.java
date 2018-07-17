package ch06;

public class VoidExam {
	static void hello(){
		System.out.println("안녕하세요?");
		return;
	}
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		hello();
		System.out.println("프로그램 끝");
	}
}
