package ch12;
// InnerClass.class		InnerClass$Inner.class
public class InnerClass {
	private static int x=10;
	//내부 클래스(외부 클래스의 멤버를 자유롭게 사용 가능)
	class Inner { 
		int getX(){
			return x;
		}
	}
	public static void main(String[] args) {
		System.out.println(x);
		//외부 클래스 인스턴스
		InnerClass e = new InnerClass();
		//외부클래스.내부클래스
		InnerClass.Inner in = e.new Inner();
		System.out.println(in.getX());
	}
}
