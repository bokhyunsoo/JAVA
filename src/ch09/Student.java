package ch09;

public class Student {
	//멤버변수
	protected String name;
	protected String num;
	protected String major;
	protected int year;
	public Student() {} //기본 생성자
	public Student(String name, String num, String major, int year) {
		this.name = name;
		this.num = num;
		this.major = major;
		this.year = year;
	}
	public void input(String name, String num, String major, int year){
		this.name = name;
		this.num = num;
		this.major = major;
		this.year = year;
	}
	public void print(){
		System.out.println("이름\t학번\t전공\t학년");
		System.out.println(name+"\t"+num+"\t"+major+"\t"+year);
	}
}
