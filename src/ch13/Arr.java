package ch13;

import java.util.Arrays;

public class Arr {
	public static void main(String[] args) {
		int[] num1 = {10,20,30,40,50};
		int[] num2 = {10,20,30,40,50};
		boolean b = false;
//		if(num1.length != num2.length){ //배열의 크기가 다르면
//			b=false;
//		}else{
//			for(int i=0; i<num1.length; i++){
//				if(num1[i] != num2[i]){ //내용이 다르면 반복문 종료
//					b=false;
//					break;
//				}
//			}
//		}
//		if(b=true){
		//Arrays.equals(배열1,배열2)
		if(Arrays.equals(num1, num2)){
			System.out.println("배열의 내용이 같습니다.");
		}else{
			System.out.println("배열의 내용의 틀립니다.");
		}
	}
}
