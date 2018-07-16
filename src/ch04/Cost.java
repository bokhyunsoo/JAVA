package ch04;

import java.util.Scanner;

public class Cost {
	public static void main(String[] args) {
		String name="";
		int price=0;
		int point=0;
		int point_use=0;
		int fee=0;
		int pay;
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		name=scan.next(); // 문자열 입력
		System.out.println("금액을 입력하세요:");
		price=scan.nextInt(); // 정수 입력
		System.out.println("포인트를 입력하세요:");
		point=scan.nextInt();
		// 구매금액이 2만원 미만이면 배송료 2천원
		if(price < 20000){
			fee = 2000;
		}
		// 포인트 적립액이 1만원 이상이면 포인트 사용 가능
		if(point >= 10000){
			point_use = point;
			pay = price + fee - point;
		}else{
			pay = price + fee;
		}
		System.out.println("이름\t구매금액\t배송료\t포인트사용\t결제금액");
		System.out.println(name+"\t"+price+"\t"+fee+"\t"+point_use+"\t\t"+pay);
	}
}
