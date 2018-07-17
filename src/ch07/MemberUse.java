package ch07;

public class MemberUse {
	public static void main(String[] args) {
		//자료형 객체참조변수=new 자료형();
		//Member m1 = new Member(); //객체 생성
		Member m1 = new Member(); //객체참조변수 선언
		m1.input("김철수", "kim", 50000);
		m1.setGrade();
		m1.print();
		
		Member m2 = new Member("박철호","park",1000000);
		m2.setGrade();
		m2.print();
	}
}
