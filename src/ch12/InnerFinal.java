package ch12;

public class InnerFinal {
	int x = 10;
	void print(){
		int y = 20; // final 안붙여도됨
		class Inner{ // method 내부에 선언된 내부 클래스
			void test(){
				System.out.println(x);
				System.out.println(y);
			}
		}
	}
	public static void main(String[] args) {
		InnerFinal a = new InnerFinal();
	}
}
