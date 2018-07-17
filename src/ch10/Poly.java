package ch10;

class K { //부모클래스
	int a=10;
	public void print(){
		System.out.println(a);
	}
}
class V extends K { //자식클래스
	int a = 20;
	@Override
	public void print(){
		System.out.println(a);
	}
}
public class Poly {
	public static void main(String[] args) {
		V a = new V();
		a.print();
		K b = new K();
		b.print();
//		좌변 : 부모자료형, 우변 : 자식자료형
//		자식자료형의 method 호출
//		다형성
		K c = new V();
		c.print();
	}
}
