package ch04;

public class Multi {
	public static void main(String[] args) {
		long num = 10;
		long sum = 1; //0으로 하면 안됨
		for(int i=1; i<=num; i++){
			sum *= i;
		}
		System.out.println("1~"+num+"까지의 곱 "+sum);
	}
}
