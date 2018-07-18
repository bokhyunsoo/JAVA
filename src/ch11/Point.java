package ch11;

public class Point {
	int a,b;
	//this.멤버 => 현재 클래스의 멤버
	//this() => 현재 클래스의 생성자
	public Point(){ //기본 생성자
		this(0,0);
	}
	//매개변수가 있는 생성자
	public Point(int a, int b){
		this.a = a;
		this.b = b;
	}
}
