package ch13;

import java.util.Arrays;

public class ArrSort {
	public static void main(String[] args) {
		int[] num={50,40,70,90,120,-20};
		
		//배열참조변수.length => 배열의 갯수
		
		Arrays.sort(num); // 오름차순
//		int temp=0;
//		//bubble sort(버블정렬)
//		for(int i=0; i<num.length; i++){
//			for(int j=i+1; j<num.length; j++){
//				//내림차순
//				if(num[i] > num[j]){ // 두 변수의 값을 change
//					temp = num[i]; // temp = 50
//					num[i] = num[j]; // num[0] = 40
//					num[j] = temp; // num[1] = 50
//				}
//			}
//		}
		
		// 오름차순
		for(int i=0; i<num.length; i++){
			System.out.print(num[i]+"\t");
		}
		
		// 내림차순
		System.out.println();
		for(int i=num.length-1; i>=0; i--){ //배열 데이터 출력
			System.out.print(num[i]+"\t");
		}
	}
}