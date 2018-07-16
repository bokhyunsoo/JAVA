package ch03;

import java.util.Scanner;

public class Point {
	public static void main(String[] args) {
		String name;
		int kor,eng,mat,tot;
		double avg;
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		name = scan.next(); // 문자열 입력
		System.out.println("국어 점수를 입력하세요:");
		kor = scan.nextInt(); // 정수 입력
		System.out.println("영어 점수를 입력하세요:");
		eng = scan.nextInt(); // 
		System.out.println("수학 점수를 입력하세요:");
		mat = scan.nextInt();
		scan.close();
		tot = kor+eng+mat;
		avg = tot / 3.0;
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		// % 출력할 위치
		// f 실수형, s 문자열, c 문자형, d 정수형
		// 전체자리수.소수이하자리수
		// 전체자리수에는 소수점도 포함됨
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+ String.format("%5.1f",avg)+"\t");
		//System.out.printf("%s\t%d\t%d\t%d\t%d\t%5.1f",name, kor, eng, mat, tot, avg);
		
//		2진법, 8진법, 16진법
//		
//		10진법을 2진법으로
//		
//		2진법을 10진법으로
	}
}
