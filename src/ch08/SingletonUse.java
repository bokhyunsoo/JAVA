package ch08;

public class SingletonUse {
	public static void main(String[] args) {
		//Singleton a = new Singleton();
		//static method는 클래스 이름으로 접근
		//static : 프로그램이 시작할 때 만들어지고
		//프로그램이 끝나면 메모리에서 제거됨
		//클래스이름.method() => static method
		Singleton a = Singleton.getInstance();
	}
}
