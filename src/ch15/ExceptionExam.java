package ch15;

public class ExceptionExam {
//Exception : 예외
//ArithmeticException : 산술연산 관련 예외 처리 클래스
	public static void main(String[] args) {
		int a = 10, b=0, c;
		try { //예외가 발생할 가능성이 있는 코드
			c = a / b;
			System.out.println(c);
		// ArithmeticException e = new ArithmeticException();
		} catch (Exception e) { //예외가 발생할 때의 코드
//			System.out.println("0으로 나눌 수 없습니다.");
			//예외가 발생한 상태의 스택 정보 출력
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
}
