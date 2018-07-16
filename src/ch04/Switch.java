package ch04;

public class Switch {
	public static void main(String[] args) {
		int kor=85;
		int eng=70;
		int mat=90;
		int tot = kor+eng+mat;
		double avg = tot/3.0;
		String grade="";
		
		//switch(조건식) 조건식에는 정수, 문자열만 가능
		//case 라벨:
		//조건에 맞는 라벨(label)로 이동
		switch((int)(avg/10)){
		case 10:
		case 9: grade="수"; break;
		case 8: grade="우"; break;
		case 7: grade="미"; break;
		case 6: grade="양"; break;
		default: grade="가";
		}
		
		System.out.println("국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println(kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+String.format("%5.1f",avg)+"\t"+grade);
	}
}
