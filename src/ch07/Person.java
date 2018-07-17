package ch07;
// 클래스는 속성과 동작을 정의함
// 속성 => 변수로, 동작 => method로 작성
public class Person {
	//member variable
	//private - 외부 클래스에서 참조x
	private String name;
	private int age;
	private double height;
	//setter : set+변수명
	public void setName(String name){
		//this => 멤버변수를 가리킴
		this.name = name;
	}
	//getter : get+변수명
	public String getName(){
		return name;
	}
	public void setAge(int age) {
		if(age < 0 || age > 150){
			System.out.println("입력값이 정확하지 않습니다.");
		}else{
			this.age = age;
		}
	}
	public int getAge() {
		return age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	public void print(){
		System.out.println("이름:"+name+",나이:"+age+",키:"+height);
	}
}
