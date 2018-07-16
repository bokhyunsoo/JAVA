package ch05;

public class IntArray {
	public static void main(String[] args) {
		//정수 배열 생성
		//자료형[] 배열참조변수;
		//배열참조변수[인덱스]
		//int[] num = {10, 20, 30, 40, 50};
		int[] num; //배열 참조변수 선언
		//new 자료형[갯수] 배열생성
		num = new int[5]; //시작번지값 전달
		num[0]=10; //배열참조변수[인덱스]
		num[1]=20;
		num[2]=30;
		num[3]=40;
		num[4]=50;
		//num[5]=60; 범위 초과
//		for(int i=0; i<5; i++){
//			System.out.println(num[i]);
//		}
	//확장 for문(향상된 for문), java 1.5부터 사용가능
		//for(개별 : 집합변수)
		for(int n : num){
			System.out.println(n);
		}
	}
}
