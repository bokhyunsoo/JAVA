package ch06;

public class Gugu {
	static void gugu(int dan){
		for(int i=1; i<=9; i++){
			System.out.println("====="+dan+"단=====");
			System.out.println(dan+"x"+i+"="+dan*i);
		}
	}
	static void guguAll(){
		for(int i=2; i<=9; i++){
			System.out.println("====="+i+"단=====");
			for(int j=1; j<=9; j++){
				System.out.println(i+"x"+j+"="+i*j);
			}
		}
	}
	
	public static void main(String[] args) {
		guguAll();
//		gugu(5);
//		gugu(7);
		
//		for(int i=2; i<=9; i++){
//			gugu(i);
//		}
	}
}
