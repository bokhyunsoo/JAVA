package ch02;

public class Ex04 {
	public static void main(String[] args) {
		//문자형 변수 ch에 'A' 저장(숫자 65가 저장됨)
		char ch='\0'; // null
		System.out.println(ch);
		// (자료형) 형변환, cast 연산자
		System.out.println((int)ch);
		int a =65;
		System.out.println(a);
		System.out.println((char)a);
		for(int i=0; i<=255; i++){
			System.out.println(i+"==>"+(char)i);
		}
		System.out.println("한글 코드 확인");
		for(int i='가'; i<='핳'; i++){
			System.out.println((char)i+"==>"+i);
		}
		System.out.println("한자 코드 확인");
		for(int i='可'; i<='霞'; i++){
			System.out.println((char)i+"==>"+i);
		}
		//문자열 참조변수 str이 "AB" 문자열을 가리킴
		String str="";
		System.out.println(str);
		str=null;
		str=" ";
	}
}
