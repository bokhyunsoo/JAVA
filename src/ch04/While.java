package ch04;

public class While {
	public static void main(String[] args) {
		int i=1;
		//while(조건식) 조건식이 true일동안 반복실행
		while( i<=10 ){
			//출력 후 i의 값이 증가됨
			//i증가 후 출력
			System.out.println(++i);
		}
	}
}
