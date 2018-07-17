package ch09;

public class Area {
	//멤버변수
	private int width;
	private int length;
	//생성자
	public Area() { }
	public Area(int width, int length){
		this.width = width;
		this.length = length;
	}
	public int getArea(){
		return width*length;
	}
}
