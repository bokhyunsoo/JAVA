package ch04;

public class Continue {
	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			//5의 배수이면
			//if (i % 5 == 0) break;
			if (i % 5 == 0) continue;
			System.out.println(i);
		}
		System.out.println("프로그램 종료");
	}
}

// Class 영역 : method, code, static, constant
//Stack 영역 : method 호출, 지역변수
//Heap 영역 : 동적 메모리 할당 공간, 인스턴스, 배열
//Native method 영역 : C언어 함수 공간
//pc register 영역 : 현재 실행중인 부분의 명령어와 주소가 저장