package ch06;

public class Return {
	static int sum(int a){
		int result=0;
		for(int i=1; i<=a; i++){
			result = result + i;
		}
		return result; //method를 호출한 곳으로 되돌려줌
	}
	
	public static void main(String[] args) {
		int n = sum(50); //method 호출
		System.out.println(n);
		n = sum(100);
		System.out.println(n);
	}
}
