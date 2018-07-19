package ch15;

public class ThrowExam {
	static void test(int n){
		if(n == 0){
			throw new NullPointerException();
		}
	}
	
	public static void main(String[] args) {
		test(0);
	}
}
