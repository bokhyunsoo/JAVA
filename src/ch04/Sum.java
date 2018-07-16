package ch04;

public class Sum {
	public static void main(String[] args) {
		//int num = 5;
		int num = Integer.parseInt(args[0]);
		int sum = 0;
		for (int i=1; i<=num; i++){
			sum = sum + i;
		}
		System.out.println("1-"+num+"까지의 합계"+sum);
	}
	
}
