package ch07;

public class EmplyeeUse {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.input("김철수", "관리부", "과장", 3000000);
		e1.calc();
		System.out.println(e1);
	}
}
