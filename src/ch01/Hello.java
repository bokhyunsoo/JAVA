package ch01;

public class Hello {
	//JVM(Java Virtual Machine)이 main method를 실행시킴
	//F3(소스코드)
	public static void main(String[] args){
		System.out.println("hello java");
	}
}

// 접근권한 지정자(modifier)

//public - 접근 제한이 없다.(같은 프로젝트 내에 어디서든 사용 가능)
//protected - 같은 패키지 + 다른 패키지의 경우 자손클래스에서 접근 가능
//default - 같은 패키지 내에서만 접근 가능
//private - 클래스 내부에서만 사용 가능(외부 클래스에서 접근 불가능)

//static 정적인 <---------------> dynamic 동적인

//리턴타입-void => 리턴 값이 없다.
//리턴타입 method이름(매개변수){
//	코드;
//}