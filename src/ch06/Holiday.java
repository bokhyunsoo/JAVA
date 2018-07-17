package ch06;

import java.util.Scanner;

public class Holiday {
	static int y; //전역변수, 맴버변수
	static void input(){
		Scanner scan = new Scanner(System.in);
		System.out.println(" 근속연수를 입력하세요:");
		y = scan.nextInt(); //정수값 입력
		scan.close(); // 스캐너에서 사용한 메모리 정리
	}
	static int holiday(int year){
		int day = 0;
		if(year <= 5){
			day = 10;
		}else if(year <= 10){
			day = 15;
		}else{
			day=20;
		}
		return day;
	}
	public static void main(String[] args) {
		input();
		System.out.println("휴가일수:"+holiday(y));
	}
}
