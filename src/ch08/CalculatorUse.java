package ch08;

public class CalculatorUse {
	public static void main(String[] args) {
		//객체(인스턴스) 생성
		Calculator c1 = new Calculator();
		//입력
		c1.setLeft(10);
		c1.setRight(10);
		//출력
		System.out.println(c1.getLeft());
		System.out.println(c1.getRight());
		
		Calculator c2 = new Calculator(10, 20);
		c2.sum();
		c2.avg();
		
		Calculator c3 = new Calculator(20, 40);
		c3.sum();
		c3.avg();
	}
}
