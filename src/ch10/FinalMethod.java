package ch10;

class T {
	private int num=10;
	//final method : 오버라이드가 금지됨
	public void print(){
		System.out.println(num);
	}
}

public class FinalMethod extends T {
	int num = 100;
	//@override//annotation, 코드에 대한 주석
	public void print() { // method 재정의
		System.out.println(num);
	}
	public static void main(String[] args) {
		FinalMethod f = new FinalMethod();
		f.print();
	}
}
