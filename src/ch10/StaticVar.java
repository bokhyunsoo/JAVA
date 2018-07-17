package ch10;
// static : 프로그램이 시작되면 클래스 영역에 자동 로딩
// nostatic : 인스턴스가 생성될 때 만들어짐
public class StaticVar {
	static int a =10; // static member
	int b= 20; // nonstatic member
	public static void main(String[] args) {
		System.out.println(a);
		//System.out.println(b);
		StaticVar s = new StaticVar();
		System.out.println(s.b);
	}
}
