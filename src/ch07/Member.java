package ch07;

public class Member {
	private String name;
	private String userid;
	private int money; //구매금액
	private String grade; //10만원 이상 gold, silver
	public Member() {
		System.out.println("기본 생성자 호출...");
	}
	//매개변수가 있는 생성자
	public Member(String name, String userid, int money) {
		System.out.println("매개변수가 있는 생성자 호출...");
		this.name = name;
		this.userid = userid;
		this.money = money;
	}

	public void input(String name, String userid, int money){
		this.name = name;
		this.userid = userid;
		this.money = money;
	}
	public void setGrade(){
		if(money >= 100000){
			grade="gold";
		}else{
			grade="silver";
		}
	}
	public void print(){
		System.out.println("이름\t아이디\t구매금액\t등급\t");
		System.out.println(name+"\t"+userid+"\t"+money+"\t"+grade);
	}
	
}
