package ch04;

public class Args {
	//명령행 매개변수(command line arguments)
	public static void main(String[] args) {
	//자바 클래스를 실행할 때 옵션을 주는 것
	//입력한 매개변수들은 배열로 저장됨, args 참조변수가 가리킴
	//배열참조변수.length => 배열의 사이즈
	//배열참조변수[인덱스] 인덱스는 0부터 시작
		for(int i=0; i<args.length; i++){
			System.out.println(i+"번째 매개변수:"+args[i]);
		}
	}
}
