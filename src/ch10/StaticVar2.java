package ch10;
//static member는 1개만 생성됨
public class StaticVar2 {
	static int total; // 클래스 영역에 생성됨
	private String model; // heap 영역에 생성됨
	public StaticVar2(String model){
		this.model = model;
		total++;
	}
	
	public static void main(String[] args) {
		StaticVar2 car1 = new StaticVar2("소나타");
		StaticVar2 car2 = new StaticVar2("모닝");
		StaticVar2 car3 = new StaticVar2("아반테");
		System.out.println(total);
		System.out.println(StaticVar2.total);
//		System.out.println(car1.total);
//		System.out.println(car2.total);
//		System.out.println(car3.total);
		System.out.println(car1.model);
		System.out.println(car2.model);
		System.out.println(car3.model);
	}
}
