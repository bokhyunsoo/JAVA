package ch04;

public class Break {
	public static void main(String[] args) {
		int i=1;
		//break : switch, for, while, do~while에서 사용됨
		while(true){ //무한반복
			System.out.println(i++);
			if(i>10) break; // 반복문을 종료시킴
		}
		System.out.println("프로그램 종료");
	}
}
