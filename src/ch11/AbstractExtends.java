package ch11;
// 추상클래스 상속 => 추상 method를 구현(implement)해야함
public class AbstractExtends extends AbstractClass {
	
	@Override
	void method1() {
		System.out.println("추상 method를 완성한 method");
	}
	public static void main(String[] args) {
		AbstractClass ex = new AbstractExtends();
		ex.method1();
		ex.method2();
	}

}
