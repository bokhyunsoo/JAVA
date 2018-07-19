package ch15;

public class ThrowsExam {
	// method 내부에서 예외가 발생하면
	// 직접 처리하지 않고 예외처리 클래스로 보내서 처리
	public static void main(String[] args) throws InterruptedException {
		for(int i=1; i<=10; i++){
			System.out.println(i);
			Thread.sleep(1000); // Interrupt(cpu 간섭)
		}
	}
}
