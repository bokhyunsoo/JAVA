package ch13;

import java.util.Random;

public class MathExam {
	public static void main(String[] args) {
		//올림
		System.out.println(Math.ceil(10.1));
		//반올림
		System.out.println(Math.round(10.5));
		//버림
		System.out.println(Math.floor(10.9));
		// Math.pow(값,지수)
		System.out.println(Math.pow(10, 3));
		System.out.println(Math.pow(2, 3));
		Random rand = new Random();
		System.out.println("정수값:"+rand.nextInt(100));
		System.out.println("실수값:"+rand.nextDouble());
		// 0.0 ~ 1.0 미만의 난수
		for(int i=1; i<=10; i++){
			System.out.println(Math.random());			
		}
		System.out.println((int)(Math.random()*100));			
	}
}
