package ch09;

public class SaleUse {
	public static void main(String[] args) {
		Sale s1 = new Sale(); //객체(인스턴스) 생성
		s1.input(1, "냉장고", "LG", "2017-01-01", 1000000, 10);
		// 데이터 입력
		s1.calc(); // 계산
		s1.print(); // 출력
	}
}

