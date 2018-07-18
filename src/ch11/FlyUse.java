package ch11;

public class FlyUse {
	public static void main(String[] args) {
		//인터페이스는 인스턴스를 만들 수 없음
		//Flyer f = new Flyer();
		//좌변 부모 = 우변 자식 => 다형성
		Flyer f = new Bird();
		f.takeOff();
		f.fly();
		f.land();
		f = new Airplane();
		f.takeOff();
		f.fly();
		f.land();
//		인터페이스를 구현한 클래스는 인스턴스 생성이 가능
//		Bird bird = new Bird();
//		bird.takeOff();
//		bird.fly();
//		bird.land();
//		Airplane air = new Airplane();
//		air.takeOff();
//		air.fly();
//		air.land();
	}
}
