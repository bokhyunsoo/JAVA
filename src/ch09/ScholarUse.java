package ch09;

public class ScholarUse {
	public static void main(String[] args) {
		// 자식클래스의 객체를 생성하면 부모클래스의 객체도 생성됨
		// Student 객체가 생성
		// Student 생성자 호출
		// Scholar 객체가 생성
		// Scholar 생성자 호출
		Scholar s1 = new Scholar();
		//s1.input("김철수", "2017001", "컴공",1,"1종",2500000);
		s1.input("김철수", "2017001", "컴공", 1);
		s1.print();
	}
}
