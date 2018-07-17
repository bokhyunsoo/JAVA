package ch07;

public class PointUse {
	public static void main(String[] args) {
		//Point 클래스의 객체(인스턴스) 생성
		Point p1 = new Point();
		//데이터 입력
		p1.setName("김철수");
		p1.setKor(90);
		p1.setEng(80);
		p1.setMat(89);
		//출력
		p1.print();
	}
}
