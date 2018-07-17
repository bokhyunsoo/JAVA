package ch09;
// class 자식클래스 extends 부모클래스
public class Scholar extends Student{
	private String category;
	private int money;
	public void input(String name, String num, String major, int year, String category, int money){
		// super 상위 클래스(부모클래스)
		super.input(name, num, major, year);
		this.category = category;
		this.money = money;
	}
	public void print(){
		System.out.println("이름\t학번\t전공\t학년\t구분\t장학금액");
		System.out.println(name+"\t"+num+"\t"+major+"\t"+year+"\t"+category+"\t"+money);
	}
}
