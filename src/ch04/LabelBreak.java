package ch04;

public class LabelBreak {
	public static void main(String[] args) {
		// break는 자신이 속한 블록만 벗어남
		b:
		for(int i=1; i<=5; i++){
			for(int j=1; j<=5; j++){
				// break 라벨 이름 : 라벨이 지정된 반복문 종료
				if(j==3) break b;
				System.out.println(i+","+j);
			}
			//if(i==3) break;
		}
	}
}
