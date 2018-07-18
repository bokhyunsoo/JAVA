package ch13;
//인스턴스를 복제하려면 Cloneable 인터페이스를 구현해야 함
public class Clone implements Cloneable {
	int num = 10;
	void print(){
		System.out.println(num);
	}
	public static void main(String[] args) {
		Clone t1 = new Clone();
		Clone t2 = null;
		try { //인스턴스를 복제함
			t2 = (Clone)t1.clone();
		} catch (CloneNotSupportedException e) {
			//예외가 발생한 시점의 스택 정보 출력
			//개발자를 위한 디버깅 정보 제공
			e.printStackTrace();
		}
		System.out.println(t1);
		System.out.println(t2);
		t1.print();
		t2.print();
	}
}
