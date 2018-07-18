package ch13;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("연도를 입력하세요:");
		int year = scan.nextInt();
//		GregorianCalendar cal = new GregorianCalendar();
//		if(cal.isLeapYear(year)){
		if((year%4 == 0 && year%100 !=0) || year%400==0){
			System.out.println("윤년입니다.");
		}else{
			System.out.println("펑년입니다.");
		}
	}
}