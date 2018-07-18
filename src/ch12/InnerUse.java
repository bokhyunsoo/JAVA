package ch12;

import ch11.Flyer;

public class InnerUse {
	public static void main(String[] args) {
		// new 자료형() { } => 무명클래스
		Flyer f = new Flyer(){

			@Override
			public void takeOff() {
				System.out.println("take off");
				
			}

			@Override
			public void fly() {
				System.out.println("fly");
				
			}

			@Override
			public void land() {
				System.out.println("land");
				
			}
			
		};
		f.takeOff();
		f.fly();
		f.land();
	}
}
