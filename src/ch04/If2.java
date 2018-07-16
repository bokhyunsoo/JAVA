package ch04;

public class If2 {
	public static void main(String[] args) {
	// String[] args 명령행 매개변수 command line arguments
	// Integer.parseInt(문자열) 문자열을 숫자로
	// args[0] 첫번째 명령행 매개변수
	// 배열참조변수.length => 배열의 사이즈(요소의 갯수)
	// 배열참조변수[인덱스] 0부터
		for(int i=0; i<args.length; i++){
			System.out.println(args[i]);
		}
		
		
		int num = Integer.parseInt(args[0]);
		if(num % 2 == 0){ // num을 2로 나눈 나머지가 0이면
			System.out.println(num+"은 짝수입니다.");
		} else {
			System.out.println(num+"은 홀수입니다.");
		}
	}
}
