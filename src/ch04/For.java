package ch04;

public class For {
	public static void main(String[] args) {
		// Integer.parseInt(문자열) 문자열을 숫자로 변환
		if(args.length == 0){
			System.out.println("명령행 매개변수를 입력하세요");
			System.exit(0); // 프로그램 강제 종료
		}
		
		int num = Integer.parseInt(args[0]);
		for(int i=1; i<=num; i++){
			System.out.println(i);
		}
		
//		System.out.println("종료하려면 0을 입력하세요");
//		Scanner scan = new Scanner(System.in);
//		for(;;){ // 무한루프
//			System.out.println("입력하세요");
//			int n = scan.nextInt();
//			if(n==0) break; // 탈출조건
//			System.out.println("입력한 값은"+n+"입니다.");
//		}
	}
}
