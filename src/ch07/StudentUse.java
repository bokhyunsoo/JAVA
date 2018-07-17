package ch07;

public class StudentUse {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.input("김철수", "컴공", 1, "2017001", 4.3, 5000000);
		System.out.println(s1.toString());
		//System.out.println(s1);
		//s1.print();
	}
}
