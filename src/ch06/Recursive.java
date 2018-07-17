package ch06;
//재귀호출
//factorial 계산 : 5!=5x4x3x2x1
public class Recursive {
	static long fact1(int n){
		return n==1 ? 1 : n*fact1(n-1); //재귀호출
	}
	static long fact2(int n){
		long result = 1;
		for(int i=1; i<=n; i++){
			result = result * i;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(fact1(5));
		System.out.println(fact2(5));
	}
}
