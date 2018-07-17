package ch08;
// 생성자 오버로딩
// F4 : 계층 구조 보기
public class Person {
	private String name;
	private int height;
	private int weight;
//	this.멤버변수, this() 다른 생성자 호출
	public Person() {//기본 생성자(default constructor)
		this("김철수",150,100);
	}
	public Person(String name){
		this(name,190,100);
	}
	public Person(String name, int height){
		this(name,height,50);
	}
	public Person(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	public void showInfo(){
		System.out.println("===신상 정보===");
		System.out.println("이 름 :"+name);
		System.out.println("신 장 :"+height);
		System.out.println("체 중 :"+weight);
	}
}
