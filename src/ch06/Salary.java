package ch06;

public class Salary {
	static String[] name = {"박과장","김과장","이대리","최주임","홍실장"};
	static int[] salary = {2800,3000,2500,2000,3500};
	static int[] bonus = new int[5];
	//static int[] bonus = {0,0,0,0,0};
	static int[] total = new int[5];
	static int[] tax = new int[5];
	static int[] pay = new int[5];
	static int pay_tot;
	static void calc(){
		for(int i=0; i<name.length; i++){
			bonus[i]=(int)(salary[i]*0.3);
			total[i]=salary[i]+bonus[i];
			tax[i]=(int)(total[i]*0.03);
			pay[i]=total[i]-tax[i];
			pay_tot = pay_tot + pay[i];
		}
	}
	static void print(){
		System.out.println("이름\t연봉\t보너스\t총액\t세금\t실수령액");
		for(int i=0; i<name.length; i++){
			System.out.println(name[i]+"\t"+salary[i]+"\t"+bonus[i]+
					"\t"+total[i]+"\t"+tax[i]+"\t"+pay[i]);
		}
		System.out.println("실수령액 합계:"+pay_tot);
		System.out.println("실수령액 평균:"+pay_tot/5);
	}
	public static void main(String[] args) {
		calc();
		print();
	}
}
