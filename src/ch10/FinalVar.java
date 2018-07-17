package ch10;
// final 변수
// 대문자로 작성, 2단어 이상일 경우 _로 연결
// 초기값이 반드시 필요함
// 값을 변경할 수 없음
public class FinalVar {
	final static int MAX_NUM = 100;
	public static void main(String[] args) {
		System.out.println(MAX_NUM);
		//MAX_NUM=200; //final 변수는 수정할 수 없음
	}
}
