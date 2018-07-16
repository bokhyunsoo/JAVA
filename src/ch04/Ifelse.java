package ch04;

public class Ifelse {
	public static void main(String[] args) {
		int kor=85;
		int eng=70;
		int mat=90;
		int tot = kor+eng+mat;
		double avg = tot/3.0;
		String grade="";
		if(avg >= 90 && avg <= 100){
			grade="수";
		}else if(avg >=80 && avg < 90){
			grade="우";
		}else if(avg >=70 && avg < 80){
			grade="미";
		}else if(avg >=60 && avg < 70){
			grade="양";
		}else{
			grade="가";
		}
		System.out.println("국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println(kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+String.format("%5.1f",avg)+"\t"+grade);
	}
}
