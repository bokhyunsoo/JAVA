package ch03;

public class Condition {
	public static void main(String[] args) {
		int num = -5;
		// 조건식 ? true일때의 값 : false일 때의 값
		//System.out.println(num > 0 ? num : -num);
		if(num>0){ // 조건식
			System.out.println(num); // true
		}else{
			System.out.println(-num); // false
		}
	}
	
}
