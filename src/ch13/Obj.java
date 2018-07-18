package ch13;
//Object : 자바의 최상위 클래스
public class Obj {
	public static void main(String[] args) {
		//Object e1 = new Object();
		Obj e1 = new Obj();
		System.out.println(e1.getClass()); //클래스의 정보
		System.out.println(e1); //해쉬코드 출력
		System.out.println(e1.toString());
	}
}
