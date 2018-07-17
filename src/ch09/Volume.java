package ch09;
// extends 부모클래스
public class Volume extends Area {
	
	private int height;
	
	public Volume() { //기본 생성자(default constructor)
	// super() => 부모클래스의 생성자
	// super. => 부모클래스의 변수, method
	// this() 생성자 호출
	// this. => 현재 클래스의 변수, method
		
	}
	//매개변수가 있는 생성자
	public Volume(int width, int length, int height) {
		super(width, length); //부모클래스의 생성자호출
		this.height = height;
	}
	
	public int getVolume(){
		//getArea()는 부모클래스의 method
		return getArea()*height;
	}
}
