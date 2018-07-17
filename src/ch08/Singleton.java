package ch08;

public class Singleton {
	private static Singleton instance;
	public static Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
	//기본 생성자
	private Singleton() {
	}
}
